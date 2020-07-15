package org.kly.algorithms.leetcode.medium;

import org.kly.common.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/1
 */
public class m_24_两两交换链表中的节点 {


    public ListNode swapPairs(ListNode head) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null && head.next != null) {
            pre.next = reserveNode(head, 2, head.next.next);
            pre = head;
            head = head.next;

        }
        return hair.next;
    }

    private ListNode reserveNode(ListNode node, int k, ListNode end) {
        ListNode pre = end;
        ListNode cur = node;

        while (k > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            k--;
        }
        return pre;
    }

    public static void main(String[] args) {
        m_24_两两交换链表中的节点 m = new m_24_两两交换链表中的节点();
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
//        n1.next.next = new ListNode(3);
//        n1.next.next.next = new ListNode(4);
//        n1.next.next.next.next = new ListNode(5);

        m.swapPairs(n1);
    }
}
