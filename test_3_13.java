
//LeetCode：https://leetcode-cn.com/problems/same-tree/submissions/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        // p != null && q != null && p.val == q.val
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}