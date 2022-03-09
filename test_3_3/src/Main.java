public class Main {

    public static void main(String[] args) {
	    BinaryTree binaryTree = new BinaryTree();// 实例化对象
        TreeNode root = binaryTree.createTree();// 创建树
        binaryTree.preOrder(root);// 前序遍历
        System.out.println();
        binaryTree.inOrder(root);// 中序遍历
        System.out.println();
        binaryTree.postOrder(root);// 后序遍历
        System.out.println();
        System.out.println(binaryTree.size(root));// 获取结点数 遍历思想
        System.out.println(binaryTree.otherSize(root));// 获取结点数 子问题
        System.out.println(binaryTree.getLeafNodeCount(root));// 获取叶子数 遍历思想
        System.out.println(binaryTree.otherGetLeafNodeCount(root));// 获取叶子数 子问题

    }
}
