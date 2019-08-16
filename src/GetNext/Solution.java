package GetNext;

public class Solution {

/**
 * @program: offer
 *
 * @description: 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author: makaloo
 *
 * @create: 2019-08-16 09:16
 **/
    /*
    永远记住中序的下一结点是右子树的最左边
    链接：https://www.nowcoder.com/questionTerminal/9023a0c988684a53960365b889ceaf5e
    来源：牛客网

    1.二叉树为空，则返回空；
    2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
    3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null) return null;
        TreeLinkNode p;
        if (pNode.right != null) {
            p = pNode.right;
            while (p.left != null) p = p.left;
            return p;
        }
        while (pNode.next != null) {
            p = pNode.next;
            if (p.left == pNode) return p;
            pNode = pNode.next;
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}