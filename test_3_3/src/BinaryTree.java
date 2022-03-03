import javax.swing.tree.TreeNode;

// 下面的创建方法不是常用的创建方式 比较简单 等到后期的时候 会慢慢的了解
class BTNode {
    public char val;
    public BTNode left;// 左孩子的引用
    public BTNode right;// 右孩子的引用

    public BTNode(char val) {
        this.val = val;
    }
}

public class BinaryTree {
//    public BTNode root;// 二叉树的根节点

    public TreeNode createTree() {
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
}
