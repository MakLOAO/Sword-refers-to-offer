package PrintFromTopToBottom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

/**
 * @program: offer
 *
 * @description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author: makaloo
 *
 * @create: 2019-04-18 17:18
 **/
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.remove();
            list.add(root.val);
            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
        }
        return list;
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