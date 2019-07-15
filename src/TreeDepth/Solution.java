package TreeDepth;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @author: makaloo
 *
 * @create: 2019-07-15 09:10
 **/
//    public int TreeDepth(TreeNode root) {
//        if (root == null) return 0;
//        return 1 + treeDepth(root);
//    }
//
//    private int treeDepth(TreeNode root) {
//        int leftDepth = 0, rightDepth = 0;
//        if (root.left != null) leftDepth = 1 + treeDepth(root.left);
//        if (root.right != null) rightDepth = 1 + treeDepth(root.right);
//        return Math.max(leftDepth, rightDepth);
//    }

    // 层次遍历
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0, count = 0, nextCount = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            count++; // 每次出队列都让已经遍历节点数+1
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            // count已经遍历了的节点数，nextCount下层的节点总数；当count==nextCount的时候，代表本层的节点已经遍历完毕
            if (count == nextCount) {
                nextCount = queue.size(); // 当count==nextCount的时候，代表本层的节点已经遍历完毕，此时队列里剩下的都是下一层的节点
                count = 0; // 开始遍历下一层节点时，让已经遍历节点数归零
                depth++; // 本层节点已经遍历完毕，层数+1
            }
        }
        return depth;
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

