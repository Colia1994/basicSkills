package org.kly.algorithms.leetcode.medium;

import org.kly.infrastructure.common.ListNode;

public class m_369 {

    public ListNode plusOne(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode leftNot9 = dummy;

        while (prev.next != null) {

            if (prev.next.val != 9) {
                leftNot9 = prev.next;
            }
            prev = prev.next;
        }
        //prev此时移动到了尾节点
        leftNot9.val++;
        while (leftNot9.next != null) {
            leftNot9 = leftNot9.next;
            leftNot9.val = 0;
        }
        return dummy.val != 0 ? dummy:dummy.next;
    }


}
