package org.kly.basicSkills.algorithm.leetcode.easy;

import org.kly.common.ListNode;

/**
 * 单向链表翻转
 * @author colia
 * @date 2018/12/18 0:40
 */
public class e_206_反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {

            ListNode tl = cur.next;

            cur.next = pre;
            pre = cur;
            cur = tl;
        }
        return pre;
    }

    private static Node travel(Node head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        Node nowNode = head.next;
        Node leftNode = head;
        Node rightNode;
        while(nowNode != null){
            rightNode = nowNode.next;
            nowNode.next = leftNode;
            leftNode = nowNode;
            nowNode = rightNode;
        }
        head.next = null;
        head.print(leftNode);
        return leftNode;
    }

    private static class Node {
        int val;
        Node next;

        Node(int value) {
            this.val = value;
            this.next = null;
        }

        void print(Node node) {
            Node current = node;
            while (current != null) {
                System.out.print(current.val + "->");
                current = current.next;
            }
            System.out.println("all");

        }

        //初始化链表,并且返回表头
        Node init() {
            Node head = new Node(0);
            Node current = head;
            for (int i = 1; i < 10; i++) {
                //如果头结点为空,为头结点
                current.next = new Node(i);
                current = current.next;

            }
            return head;
        }
    }

}
