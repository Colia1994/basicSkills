package org.kly.algorithms.leetcode.medium;

import org.kly.infrastructure.common.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/8
 */
public class m_92_反转链表_II {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Empty list
        if (head == null) {
            return null;
        }
        int length = n - m + 1;
        ListNode new_head = new ListNode(0);
        new_head.next = head;
        ListNode pre = new_head;
        ListNode node_m = head;
        ListNode end = head;
        while (m > 1) {
            pre = node_m;
            node_m = node_m.next;
            end = end.next;
            m--;
            n--;
        }

        while (n > 0) {
            end = end.next;
            n--;
        }
        while (length > 0) {
            ListNode ls = node_m.next;
            node_m.next = end;
            end = node_m;
            node_m = ls;
            length--;
        }
        pre.next = end;
        return new_head.next;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }

}
