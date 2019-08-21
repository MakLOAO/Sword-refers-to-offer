package KthNode;

import java.util.LinkedList;

public class Solution {

/**
 * @program: offer
 *
 * @description: 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author: makaloo
 *
 * @create: 2019-08-21 08:46
 **/

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null) return null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = pRoot;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (--k == 0) return p;
                p = p.right;
            }
        }
        return null;
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