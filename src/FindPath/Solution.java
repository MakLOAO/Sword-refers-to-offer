package FindPath;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

/**
 * @program: offer
 *
 * @description: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * @author: makaloo
 *
 * @create: 2019-04-26 07:57
 **/
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        if (root == null) return paths;
        find(paths, new ArrayList<Integer>(), root, target);
        return paths;
    }

    // 算法思想：每有一个分支就创建一个path，该path值为父path+新结点的值
    public void find(ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> path, TreeNode root, int target){
        path.add(root.val);
        if (root.left == null && root.right == null){
            if (target == root.val){
                paths.add(path);
            }
            return;
        }
        ArrayList<Integer> path2 = new ArrayList<>();
        path2.addAll(path);
        if (root.left != null) find(paths, path, root.left, target - root.val);
        if (root.right != null) find(paths, path2, root.right, target - root.val);
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