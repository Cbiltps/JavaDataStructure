/**
106. 从中序与后序遍历序列构造二叉树
https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int postIndex = 0;
    public TreeNode createTreeByPostorderAndInoder(int[] inorder, int[] postorder, int inBegin, int inEnd) {
        // 没有左树或者右树
        if (inBegin > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        // 找到根在中序遍历的位置
        int rootInorder = findIndexOfInorder(inorder, inBegin, inEnd, postorder[postIndex]);
        if (rootInorder == -1) {
            return null;
        }
        postIndex--;
        root.right = createTreeByPostorderAndInoder(inorder, postorder, rootInorder+1, inEnd);
        root.left = createTreeByPostorderAndInoder(inorder, postorder, inBegin, rootInorder-1);
        return root;
    }

    private int findIndexOfInorder(int[] inorder, int inBegin, int inEnd,  int target) {
        for(int i = inBegin; i <= inEnd; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        postIndex = postorder.length - 1;
        return createTreeByPostorderAndInoder(inorder, postorder, 0, inorder.length-1);
    }
}