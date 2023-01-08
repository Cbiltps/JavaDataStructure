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
        binaryTree.levelOrder(root);// 层序遍历
        System.out.println();
        System.out.println(binaryTree.levelOrderOfArray(root));// 层序遍历(以数组形式展示)
        System.out.println(binaryTree.size(root));// 获取结点数 遍历思想
        System.out.println(binaryTree.otherSize(root));// 获取结点数 子问题
        System.out.println(binaryTree.getLeafNodeCount(root));// 获取叶子数 遍历思想
        System.out.println(binaryTree.otherGetLeafNodeCount(root));// 获取叶子数 子问题
        System.out.println(binaryTree.getKLevelNodeCount(root, 3));// 获取第K层的结点数
        System.out.println(binaryTree.getHeight(root));// 获取树的高度

        try {
//        System.out.println(binaryTree.nodeFind(root, 'E').val);// 下面的样子写也是可以的
            TreeNode ret = binaryTree.nodeFind(root, 'E');
            System.out.println(ret.val);
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("没有这个结点！");
        }

        System.out.println(binaryTree.isCompleteTree(root));// 判断一个树是不是完全二叉树
    }
}
