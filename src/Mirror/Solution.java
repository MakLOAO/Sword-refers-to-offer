package Mirror;

public class Solution {

    /**
     * @program: offer
     *
     * @description: 操作给定的二叉树，将其变换为源二叉树的镜像。
     *
     * @author: makaloo
     *
     * @create: 2019-09-02 19:22
     **/
    /*
    二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5

    	实现方法：只需要依次交换每个非叶结点的左右子树即可
     */

    public void Mirror(TreeNode root) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null) Mirror(root.left);
            if (root.right != null) Mirror(root.right);
        }
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