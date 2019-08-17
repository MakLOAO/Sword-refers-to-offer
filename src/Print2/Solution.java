package Print2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {

/**
 * @program: offer
 *
 * @description: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * @author: makaloo
 *
 * @create: 2019-08-17 09:30
 **/
    // 重点题！！！！！层次遍历的改造版！！！！！
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode p;
        queue.addLast(null);
        queue.addLast(pRoot);
        while (queue.size() != 1) {
            p = queue.removeFirst();
            if (p == null) {
                ArrayList<Integer> list = new ArrayList<>();
                Iterator<TreeNode> iter = queue.iterator();
                while (iter.hasNext()) {
                    list.add(iter.next().val);
                }
                ans.add(list);
                queue.add(null);
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