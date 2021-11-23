//package com.company;
//
//public class Main {
//
////    public static void main(String[] args) {
////	    int a = 12;
////        int b = 23;
////        if (a>b) {
////            System.out.println("123");
////        }
////        System.out.println("345");
////    }
//
//
//
//
//}


/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/


/**
 * 删除链表中重复的结点
 * 这个是在牛客网上测试通过的代码！
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&&tqId=11209&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 */
public class Solution {
    public ListNode deleteDuplication(ListNode head) {
        ListNode cur = head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                //使置相同值的结点往后移
                //当最后一个结点和前面的结点相同时
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;//这里要多走一步
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        //防止最后一个结点的值也是重复的
        tmp.next = null;
        return newHead.next;
    }
}
