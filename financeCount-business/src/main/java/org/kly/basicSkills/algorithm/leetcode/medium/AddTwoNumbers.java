package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author colia
 * @date 2018/12/16 0:35
 */
public class AddTwoNumbers {

    /**
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        return add(answer, l1, l2, false);
    }

    /**
     * 第一次答案 递归
     */
    private ListNode add(ListNode answer, ListNode l1, ListNode l2, boolean add) {
        if (l1 == null && l2 == null) {
            return answer;
        }
        ListNode answer1 = new ListNode(0);
        int i = add ? 1 : 0;
        int l1int = l1 == null ? 0 : l1.val;
        int l2int = l2 == null ? 0 : l2.val;
        ListNode l1next = l1 == null ? null : l1.next;
        ListNode l2next = l2 == null ? null : l2.next;
        answer.val = l1int + l2int + i;
        if (answer.val >= 10) {
            answer.val = answer.val - 10;
            add = true;
        } else {
            add = false;
        }
        if (l1next == null && l2next == null) {
            if (add) {
                answer.next = new ListNode(1);
            }
            return answer;
        }
        answer.next = answer1;
        add(answer1, l1next, l2next, add);
        return answer;
    }

    /**
     * 第一次答案 优化
     */
    private ListNode addSecond(ListNode answer, ListNode l1, ListNode l2) {
        int l1int = l1 == null ? 0 : l1.val;
        int l2int = l2 == null ? 0 : l2.val;
        int answerInt = answer.val;
        ListNode l1next = l1 == null ? null : l1.next;
        ListNode l2next = l2 == null ? null : l2.next;

        answerInt = answerInt + l1int + l2int;

        answer.val = answerInt % 10;
        answer.next = new ListNode(answerInt / 10);
        if (l1next == null && l2next == null) {
            if (answerInt / 10 == 0) {
                answer.next = null;
            }
            return answer;
        }
        addSecond(answer.next, l1next, l2next);
        return answer;
    }

    /**
     * solution
     */
    public ListNode addTwoNumbersSolution(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /**
     * 20200107
     */
    public ListNode addTwoNumbers20200107(ListNode l1, ListNode l2) {
        int common = 0;
        ListNode result = new ListNode(0);
        ListNode next = result;
        while (l1 != null || l2 != null || common == 1) {
            int l1Int = l1 == null ? 0 : l1.val;
            int l2Int = l2 == null ? 0 : l2.val;
            int nodeInt = l1Int + l2Int + common;
            common = 0;
            if (nodeInt >= 10) {
                nodeInt = nodeInt - 10;
                common = 1;
                next.next = new ListNode(nodeInt);
            } else {
                next.next = new ListNode(nodeInt);
            }
            next = next.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
