/**
236. 二叉树的最近公共祖先
https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/ 
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // 思路一:
 // 按照 二叉搜索树的特性 推出方法!
 // 二叉树的第四节课(结束时间是005041)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
        if (leftTree == null) {
            return rightTree;
        } else if (rightTree == null) {
            return leftTree;
        } else {
            return root;
        }
    }
}

// 思路二:
// 按照 孩子双亲表示法-链表交叉节点(使用栈) 推出方法!
// 二叉树的第四节课(结束时间是013500)
class Solution {
    public boolean getPath(TreeNode root, TreeNode target, Stack<TreeNode> stack) {
        if (root == null || target == null) {
            return false;
        }
        stack.push(root);
        if (root == target) {
            return true;
        }
        if (getPath(root.left, target, stack)) {
            return true;
        }
        if (getPath(root.right, target, stack)) {
            return true;
        }
        stack.pop();
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        getPath(root, p, stack1);
        getPath(root, q, stack2);

        int size1 = stack1.size();
        int size2 = stack2.size();
        
        if (size1 > size2) {
            int size = size1 - size2;
            while (size != 0) {
                stack1.pop();
                size--;
            }

            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                if (stack1.peek() == stack2.peek()) { // 判断地址是否相同
                    return stack1.pop();
                } else {
                    stack1.pop();
                    stack2.pop();
                }
            }
        } else {
            int size = size2 - size1;
            while (size != 0) {
                stack2.pop();
                size--;
            }

            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                if (stack1.peek() == stack2.peek()) {
                    return stack1.pop();
                } else {
                    stack1.pop();
                    stack2.pop();
                }
            }           
        }
        return null;
    }
}