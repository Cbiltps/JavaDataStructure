/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 *
 *
 * 题目有点长直接贴链接 这个是在leetcode上通过的代码！
 *
 * 注意：一步一步优化在下面！
 *
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode pl = headA;
        ListNode ps = headB;
        int lenA = 0;
        int lenB = 0;
        //计算链表的长度
        while (pl != null) {
            lenA++;
            pl = pl.next;
        }
        //题目中说 保持原始结构，head不能动，pl和ps能动，pl和ps还要用就指向头
        pl = headA;
        while (ps != null) {
            lenB++;
            ps = ps.next;
        }
        ps = headB;
        int len = lenA - lenB;//计算差值为len步
        if (len < 0) { //pl永远指向最长的链表 ps永远指向最短的链表
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        //pl走len步
        for (int i = 1; i <= len; i++) {
            pl = pl.next;
        }
        //同时走，直到相遇
        while (pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }
}