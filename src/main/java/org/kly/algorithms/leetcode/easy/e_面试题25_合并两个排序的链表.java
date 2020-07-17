package org.kly.algorithms.leetcode.easy;

import org.kly.infrastructure.common.ListNode;

/**
 * 面试题25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 *
 * @Author Colia
 * @Date 2020/1/7 13:28
 */
public class e_面试题25_合并两个排序的链表 {



    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode resultNode = new ListNode(0);
        ListNode flowNode = resultNode;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                flowNode.next = l2;
                break;
            } else if (l2 == null) {
                flowNode.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                flowNode.next = l1;
                l1 = l1.next;
            } else {
                flowNode.next = l2;
                l2 = l2.next;
            }
            flowNode = flowNode.next;
        }
        return resultNode.next;
    }

}
