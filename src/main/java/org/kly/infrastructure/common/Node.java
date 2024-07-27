package org.kly.infrastructure.common;

/**
 * @author konglingyao
 * @date 2024/7/26
 */
public class Node {

    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
