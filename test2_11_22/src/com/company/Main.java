/**
 * 注意：这个是牛客网的题 题目直接看我下面的链接吧！
 * 只是一个存代码的文档，复制到牛客可以运行！
 * https://www.nowcoder.com/practice/0e27e0b064de4eacac178676ef9c9d70?tpId=8&&tqId=11004&rp=2&ru=/activity/oj&qru=/ta/cracking-the-coding-interview/question-ranking
 */

import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                //情况一：第一个位置为空时（bs为空）
                if (bs == null) {
                    bs = cur;
                    be = cur;
                    //情况二：第一个位置不为空（bs不为空）
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if (as == null) {
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //当所有值大于x时（before标志的链表为空）
        if (bs == null) {
            return as;
        }
        be.next = as;
        //当最后一个结点不为空时
        if (as != null) {
            ae.next = null;
        }
        return bs;
    }
}