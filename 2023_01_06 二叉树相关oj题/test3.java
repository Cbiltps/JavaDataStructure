/**
101. 对称二叉树
https://leetcode.cn/problems/symmetric-tree/
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

    public boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }

        // if ((leftTree == null && rightTree != null) || (leftTree != null && rightTree == null) ) {
        //     return false;
        // } // 下面的逻辑一样, 写法更简单
        if (leftTree == null || rightTree == null) {
            return false;
        }

        if (leftTree.val != rightTree.val) {
            return false;
        }

        return isSymmetricChild(leftTree.left, rightTree.right) && isSymmetricChild(leftTree.right, rightTree.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChild(root.left, root.right);
    }
}