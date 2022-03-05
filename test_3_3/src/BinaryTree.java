
// 下面的创建方法不是常用的创建方式 比较简单 等到后期的时候 才会展示真正的创建方式
class TreeNode {
    public char val;
    public TreeNode left;// 左孩子的引用
    public TreeNode right;// 右孩子的引用

    public TreeNode(char val) { // 构造方法
        this.val = val;
    }
}

public class BinaryTree {
//    public TreeNode root;// 这个表示的是二叉树的根节点

    public TreeNode createTree() { // 二叉树就是这样打印出来的
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    //前序遍历
    void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
