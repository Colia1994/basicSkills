package org.kly.algorithms.leetcode.medium;

import org.kly.infrastructure.common.ListNode;

public class m_82 {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode pre = new ListNode(0);

        ListNode now = new ListNode(0);
        now.next = head;
        pre.next = now;
        int del = -200;
        while (now != null && now.next != null ) {

            if(now.next.val == del || (now.next.next != null && now.next.val == now.next.next.val) ) {
                //需要删除now.next
                del = now.next.val;
                now.next = now.next.next;
            } else {
                now = now.next;
            }
        }
        return pre.next.next;
    }
}
