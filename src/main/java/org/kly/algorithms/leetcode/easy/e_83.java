package org.kly.algorithms.leetcode.easy;

import org.kly.infrastructure.common.ListNode;

public class e_83 {

    public ListNode deleteDuplicates(ListNode head) {


        ListNode now = new ListNode(0);
        now.next = head;
        int del = -200;
        while (now != null && now.next != null && now.next.next!=null) {

            if(now.next.val == now.next.next.val || now.next.val == del) {
                //需要删除now.next
                del = now.next.val;
                now.next = now.next.next;
            } else {
                now = now.next;
            }
        }
        return head;

    }
}
