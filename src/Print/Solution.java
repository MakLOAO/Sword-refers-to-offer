package Print;

import java.util.*;

public class Solution {

/**
 * @program: offer
 *
 * @description: 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author: makaloo
 *
 * @create: 2019-08-17 08:37
 **/

    // 实现方法：依旧和层次遍历的相似，只不过在各层之间添加null做分隔，当queue.size()==1时意味只剩下一个null，退出循环
    // Boolean变量leftToRigth指示从左到右或从右到左访问
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) return ans;
        ArrayList<Integer> layerList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode p = pRoot;
        boolean leftToRight = true;
        queue.addLast(null);
        queue.addLast(p);
        while (queue.size() != 1) {
            p = queue.removeFirst();
            if (p == null) {
                Iterator<TreeNode> iter;
                if (leftToRight)
                    iter = queue.iterator();
                else iter = queue.descendingIterator();
                while (iter.hasNext())
                    layerList.add(iter.next().val);
                ans.add(new ArrayList<>(layerList)); // 必须重新构建一个新的ArrayList！
                layerList.clear();
                queue.addLast(null);
                leftToRight = !leftToRight;
                continue;
            }
            if (p.left != null) queue.addLast(p.left);
            if (p.right != null) queue.addLast(p.right);
        }
        return ans;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}