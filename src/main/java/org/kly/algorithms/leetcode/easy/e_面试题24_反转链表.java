package org.kly.algorithms.leetcode.easy;

import org.kly.infrastructure.common.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 *
 * @Author Colia
 * @Date 2020/3/12.
 */
public class e_面试题24_反转链表 {


    //非递归实现
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }


    public ListNode reverseListDigui(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseListDigui(head.next);
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        return cur;
    }


}
