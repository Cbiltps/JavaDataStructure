/**
110. 平衡二叉树
https://leetcode.cn/problems/balanced-binary-tree/
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return (Math.abs(leftHeight - rightHeight) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
}

// 这个时候大家注意了, 这个时候还可以再优化吗?
// 注意:此时某个节点如果可以判断此树是一个不平衡的树, 那么是否可以减少递归的次数?
// 答案是可以的, 这会减少很多不需要递归的次数!
// 这是一道 字节跳动 的面试题, 注意不是笔试题!
// 关于这题的解析, 看一先看比特课件的题号再去看录播(二叉树的第三节课)!
// 下面是优化之后的代码:

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
    //     return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
        if (leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            // 说明不平衡
            return -1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
    //     int leftHeight = maxDepth(root.left);
    //     int rightHeight = maxDepth(root.right);
    //     return (Math.abs(leftHeight - rightHeight) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    // }
    return maxDepth(root) >= 0;
    }
}