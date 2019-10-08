package HasSubtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    /**
     * @program: offer
     *
     * @description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * @author: makaloo
     *
     * @create: 2019-04-16 22:05
     **/

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if (root1.val == root2.val) {
            if (judge(root1, root2))
                return true; // 不能直接return，因为当前节点如果不符合，它的左右子树也有可能符合
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean judge(TreeNode node1, TreeNode node2) {
        // 当node2==null，表示tree2遍历完了，且都能对应tree1，则返回true
        if (node2 == null) return true;
        // 当node1==null，node2仍不为null，则返回false
        if (node1 == null) return false;
        // 只要有一个点没对应上，就返回false
        if (node1.val != node2.val) return false;
        return judge(node1.left, node2.left) && judge(node1.right, node2.right);
    }

    // 算法思想：遍历A，在A中找到与B相等的所有结点，保存进队列，a=出队，然后遍历B，判断b与A的相等性
    // 需要考虑的情况：     1. root2为null；  2.A中多个结点与B的根节点相等；  3.遍历过程中如果a==null而b!=null的情况
    public boolean HasSubtree1(TreeNode root1,TreeNode root2) {
        if (root2 == null) return false;
        TreeNode a = root1, b = root2;
        boolean hasSub;
        // 中序遍历，找到与A相等的结点
        Stack<TreeNode> stackb = new Stack<>();
        Stack<TreeNode> stacka = new Stack<>();
        Queue<TreeNode> list = new LinkedList<>();
        while (a != null || !stacka.empty()) {
            if (a != null) {
                stacka.push(a);
                a = a.left;
            } else {
                a = stacka.pop();
                if (a.val == b.val) list.add(a);
                a = a.right;
            }
        }
        sub:
        while (!list.isEmpty()) {
            hasSub = true;
            b = root2;
            a = list.remove();
            while (b != null || !stackb.empty()) {
                if (b != null) {
                    stacka.push(a);
                    stackb.push(b);
                    a = a.left;
                    b = b.left;
                    if (a == null && b != null) break sub;
                } else {
                    a = stacka.pop();
                    b = stackb.pop();
                    if (b.val != a.val) hasSub = false;
                    b = b.right;
                    a = a.right;
                    if (a == null && b != null) break sub;
                }
            }
            if (hasSub) return true;
        }
        return false;
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