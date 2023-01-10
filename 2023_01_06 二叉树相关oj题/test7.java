/**
JZ36 二叉搜索树与双向链表
https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&&tqId=11179&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking 
*/

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    TreeNode prev = null;
    public void inOrderToLinkList(TreeNode pCur) {
        if (pCur == null) {
            return;
        }
        inOrderToLinkList(pCur.left);
        pCur.left = prev;
        if (prev != null) {
            prev.right = pCur;
        }
        prev = pCur;
        inOrderToLinkList(pCur.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        inOrderToLinkList(pRootOfTree);
        TreeNode head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }
}