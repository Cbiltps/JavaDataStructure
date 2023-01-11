/**
105. 从前序与中序遍历序列构造二叉树
https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    public int preIndex = 0;
    public TreeNode createTreeByPreorderAndInoder(int[] preorder, int[] inorder, int inBegin, int inEnd) {
        // 没有左树或者右树
        if (inBegin > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        // 找到根在中序遍历的位置
        int rootInorder = findIndexOfInorder(inorder, inBegin, inEnd, preorder[preIndex]);
        if (rootInorder == -1) {
            return null;
        }
        preIndex++;
        root.left = createTreeByPreorderAndInoder(preorder, inorder, inBegin, rootInorder-1);
        root.right = createTreeByPreorderAndInoder(preorder, inorder, rootInorder+1, inEnd);
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return createTreeByPreorderAndInoder(preorder, inorder, 0, inorder.length-1);
    }
}