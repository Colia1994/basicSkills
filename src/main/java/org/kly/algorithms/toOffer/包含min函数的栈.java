package org.kly.algorithms.toOffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * @author colia
 * @date 2018/12/30 23:47
 */
public class 包含min函数的栈 {

    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (!minStack.empty()) {
            if (minStack.peek() < node) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(node);
            }
        } else {
            minStack.push(node);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
