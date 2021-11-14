package com.company;

public class Main {

    //翻转链表 仅仅只是一个方法
    public ListNode reverseList(ListNode head) {
        if(this.head == null) {
            return null;
        }
        ListNode cur = this.head.next;
        ListNode prev = null;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }


//    //leetcode 页面的代码如下
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode() {}
//     *     ListNode(int val) { this.val = val; }
//     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     * }
//     */
//    class Solution {
//        public ListNode reverseList(ListNode head) {
//            if(head == null) {
//                return null;
//            }
//            ListNode cur = head;
//            ListNode prev = null;
//            while (cur != null) {
//                ListNode curNext = cur.next;
//                cur.next = prev;
//                prev = cur;
//                cur = curNext;
//            }
//            return prev;
//        }
//    }

    public static void main(String[] args) {
	// write your code here
    }
}
