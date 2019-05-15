package Convert;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author: makaloo
 *
 * @create: 2019-05-14 21:40
 **/
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode p = pRootOfTree;
        inOrderTraverse(p, list);
        for (int i = 0; i < list.size() - 1; i++) {
            p = list.get(i);
            p.right = list.get(i + 1);
            list.get(i + 1).left = p;
        }
        p = list.get(list.size() - 1);
        p.left = list.get(list.size() - 2);
        p.right = null;
        return list.get(0);
    }

    private void inOrderTraverse(TreeNode root, ArrayList<TreeNode> list) {
        if (root != null) {
            inOrderTraverse(root.left, list);
            list.add(root);
            inOrderTraverse(root.right, list);
        }
    }
}

