/**
606. 根据二叉树创建字符串
https://leetcode.cn/problems/construct-string-from-binary-tree/
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
    public void myTree2str(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        if (root != null) {
            sb.append(root.val);
        }

        if (root.left != null) {
            sb.append("(");
            myTree2str(root.left, sb);
            sb.append(")");
        } else {
            // 这个是root.left == null的情况
            if (root.right == null) {
                return;
            } else {
                sb.append("()");
            }
        }

        if (root.right != null) {
            sb.append("(");
            myTree2str(root.right, sb);
            sb.append(")");
        } else {
            // 这个是root.right == null的情况
            return;
        }
    }
    public String tree2str(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        myTree2str(root, sb);
        return sb.toString();
    }
}