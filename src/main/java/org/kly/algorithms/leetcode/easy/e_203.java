package org.kly.algorithms.leetcode.easy;

import org.kly.infrastructure.common.ListNode;

public class e_203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode cur = pre;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }


        return pre.next;
    }
}
