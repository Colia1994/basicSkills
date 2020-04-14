package org.kly.basicSkills.algorithm.toOffer;

import org.kly.common.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @author colia
 * @date 2018/12/30 22:40
 */
public class 合并两个排序的链表 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(0);
        ListNode aryNode = newHead;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    ListNode newNode = list2.next;
                    list2.next = null;
                    aryNode.next = list2;
                    list2 = newNode;
                } else {
                    ListNode newNode = list1.next;
                    list1.next = null;
                    aryNode.next = list1;
                    list1 = newNode;
                }
            } else if (list1 == null) {
                aryNode.next = list2;
                list2 = null;
            } else {
                aryNode.next = list1;
                list1 = null;
            }

            aryNode = aryNode.next;
        }

        return newHead.next;
    }

}
