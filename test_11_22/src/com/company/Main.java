/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 这个是运行在leetdode上可以运行的代码！ 链接如下！ 自己看题目！
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 */

class Solution {
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while ((headA != null) && (headB != null)) {
            if (headA.val < headB.val) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA != null) {
            tmp.next = headA;
        }
        if (headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }
}