import Convert.TreeNode;

public class BinarySortTree {
    public TreeNode addNode(TreeNode root, int data){
    TreeNode node = new TreeNode(data);
    if (root == null){ // 第一次插入时，root必为空
        root = node; // 让root指向新new出来的node
        return root;
    }
    TreeNode temp = root;
    TreeNode pre = root;
    int flag = -1;//左边为0，右边为1
    while (temp != null){
        if (temp.val == data)   return root;// 如果相等，则不插入
        else if (temp.val > data){ // 如果当前的值大于插入的值，则遍历左子树
            pre = temp;
            temp = temp.left;
            flag = 0;
        }
        else{
            pre = temp;
            temp = temp.right;//进入右子树
            flag = 1;
        }
    }

    //根据标志决定是往哪个子树添加值
    if(flag == 0)
        pre.left = node;//指向node
    if(flag == 1)
        pre.right = node;
    flag = -1;
    return root;
}

    //中序遍历
    //对于中序遍历，二叉排序树的输出有序数列
    public void traverseBinarySortTree(Convert.TreeNode root){
        if(root.left != null)//如果左孩子不为空
            traverseBinarySortTree(root.left);//先遍历左子树
        System.out.println(root.val);
        if(root.right != null)
            traverseBinarySortTree(root.right);
    }
}
