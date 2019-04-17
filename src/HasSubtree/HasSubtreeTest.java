package HasSubtree;

public class HasSubtreeTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-04-17 10:13
 **/
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(0);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(2);
        TreeNode tree2 = new TreeNode(2);
        Solution s = new Solution();
        System.out.println(s.HasSubtree(tree1, tree2));
    }
}
