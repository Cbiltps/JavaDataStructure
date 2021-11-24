

/**
 *链表的回文结构
 * 这道题是在牛客上通过的代码！
 * https://www.nowcoder.com/practice/d281619e4b3e4a60a2cc66ea32855bfa?tpId=49&&tqId=29370&rp=1&ru=/activity/oj&qru=/ta/2016test/question-ranking
 */
/
public boolean chkPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }//slow现在走到了中间位置

        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }//翻转完成

        while (head != slow) {
            if (head.val != slow.val) {
                return false;
            }
            if (head.next == slow) { //如果是奇数的时候
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

