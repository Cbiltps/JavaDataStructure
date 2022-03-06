import java.util.ArrayList;
import java.util.List;

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

    /*注意：遍历的时候用的就是 递归的方法！*/
    // 前序遍历
    void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    // 后序遍历
    void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    /*但是，LeetCode上面是有返回值的：
     * 前序遍历：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/submissions/
     * 中序遍历：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
     * 后序遍历：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/
     *
     * 然后说一下：博哥说的有返回值接收一下，我觉得没有必要，我不知道，哈哈哈哈哈，我菜！
     *
     * 代码看下面：List<Character> 是改过的，因为上面的代码时大写字母！*/

    public List<Character> preorderTraversal(TreeNode root) { // 前 这个是子问题思路
        List<Character> retlist = new ArrayList<>();
        if(root == null) {
            return retlist;
        }

        retlist.add(root.val);
        // 因为方法是有返回值的 还是接收一下
        List<Character> leftList = preorderTraversal(root.left);
        retlist.addAll(leftList);
        List<Character> rightList = preorderTraversal(root.right);
        retlist.addAll(rightList);

        return retlist;
    }

    List<Character> retlist = new ArrayList<>();// 中 这个是遍历思路
    public List<Character> inorderTraversal(TreeNode root) {
        if(root == null) {
            return retlist;
        }
        inorderTraversal(root.left);
        retlist.add(root.val);
        inorderTraversal(root.right);
        return retlist;
    }

    List<Character> retlist2 = new ArrayList<>();// 后 这个是遍历思路
    public List<Character> postorderTraversal(TreeNode root) {
        if(root == null) {
            return retlist2;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        retlist2.add(root.val);
        return retlist2;

    }
}
