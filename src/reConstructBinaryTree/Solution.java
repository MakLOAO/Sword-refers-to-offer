package reConstructBinaryTree;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author: makaloo
 *
 * @create: 2019-04-12 09:47
 **/
    /*
    * 算法思想：利用递归的思想，递归找出根，左子树，右子树，难点在pre的start与end的确定
    * 必须保证in与pre长度相同，且所有元素相同（顺序可以不同）
    * 易知左子树的preStart为preStart+1，而左子树的in长度为i-1-inStart，所以左子树的preEnd为preStart+1+i-1-inStart=preStart+i-inStart
    * 同理，右子树的preEnd为preEnd（递归角度思考preStart=preStart+1，preEnd=preEnd），右子树in长度为inEnd-i-1
    * 先序的第一个结点为根结点（递归），在中序中找到先序第一个结点，其左边为其左子树，右边为右子树
    * 然后对其左子树对应的先序序列，右子树的先序序列分别递归求根，找到中序中的左子树，求右子树，依次下去
     */
public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    if (pre.length == 0 || in.length == 0 || pre.length != in.length) return null;
    return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
}

    public TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        int i = inStart;
        while (in[i] != pre[preStart]) i++;
        TreeNode root = new TreeNode(in[i]);
        root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
        root.right = reConstructBinaryTree(pre, i - inStart + preStart + 1, preEnd, in, i + 1, inEnd);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
