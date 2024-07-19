package org.kly.algorithms.leetcode.medium;

import org.kly.infrastructure.common.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * @author colia
 * @date 2018/12/26 0:19
 */
public class m_19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode first = listNode;
        ListNode second = listNode;
        n += 1;
        while (first.next != null) {
            first = first.next;
            if (n > 0) {
                n--;
            }
            if (n == 0) {
                second = second.next;
            }
        }
        assert second.next != null;
        second.next = second.next.next;
        return listNode.next;
    }


}
