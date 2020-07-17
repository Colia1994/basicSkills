package org.kly.algorithms.toOffer;

import org.kly.infrastructure.common.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author colia
 * @date 2018/12/30 22:20
 */
public class 链表中倒数第k个结点 {


    public ListNode FindKthToTail(ListNode head, int k) {


        if (head == null) {
            return null;
        }
        ListNode trueNode = head;
        ListNode firstNode = head;
        while (firstNode != null) {
            k--;
            firstNode = firstNode.next;
            if (k < 0) {
                trueNode = trueNode.next;
            }
        }
        if (k > 0) {
            return null;
        }
        return trueNode;
    }



}


