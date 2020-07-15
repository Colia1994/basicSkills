package org.kly.algorithms.leetcode.medium;

import org.kly.common.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * @Author Colia
 * @Date 2020/3/18.
 */
public class m_142_环形链表_II {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //快慢指针 龟兔赛跑 若存在环 则必然相遇
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        //若循环结束 快慢指针不一致 则返回无环
        if (fast != slow) {
            return null;
        }
        //第一次相遇的位置 离环入口的距离刚好等于 起点到环口的距离
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
