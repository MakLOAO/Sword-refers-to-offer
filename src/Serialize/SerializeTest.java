package Serialize;

public class SerializeTest {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-08-20 09:32
 **/
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(s.Serialize(root));
    }
}
