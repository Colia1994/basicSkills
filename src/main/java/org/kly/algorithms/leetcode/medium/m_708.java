package org.kly.algorithms.leetcode.medium;

import org.kly.infrastructure.common.Node;

/**
 * @author konglingyao
 * @date 2024/7/26
 */
public class m_708 {

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node n = new Node(insertVal);
            n.next = n;
            return n;
        }


        Node curr = head;
        while (curr.next != head) {
            if (curr.val <= insertVal && (curr.next.val >= insertVal)) {
                break;
            }
            if (curr.val > curr.next.val && (insertVal > curr.val || insertVal < curr.next.val)) {
                break;
            }
            curr = curr.next;
        }
        //找到了顺序最合适的
        Node ls = curr.next;
        curr.next = new Node(insertVal);
        curr.next.next = ls;
        return head;
    }
}
