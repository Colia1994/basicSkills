package org.kly.algorithms.leetcode.easy;

import org.kly.infrastructure.common.ListNode;

public class e_1474 {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;
        while (curr.next != null) {
            int step = m;
            int del = n;
            //移动
            while (step > 0 && curr.next != null) {
                curr = curr.next;
                step--;
            }
            //删除
            while (del > 0 && curr.next != null) {
                curr.next = curr.next.next;
                del--;
            }
        }


        return dummy.next;
    }
}
