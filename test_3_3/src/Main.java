public class Main {

    public static void main(String[] args) {
	    BinaryTree binaryTree = new BinaryTree();// 实例化对象
        TreeNode root = binaryTree.createTree();// 创建树
        binaryTree.preOrder(root);// 前序遍历

    }
}
