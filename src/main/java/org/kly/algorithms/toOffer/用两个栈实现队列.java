package org.kly.algorithms.toOffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author colia
 * @date 2018/12/30 19:12
 */
public class 用两个栈实现队列 {

    /**
     * 入队栈
     */
    Stack<Integer> stack1 = new Stack<>();
    /**
     * 出队栈
     */
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        if (stack1.empty()) {
            overFirstToSecond(stack2, stack1);
        }
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            overFirstToSecond(stack1, stack2);
        }
        return stack2.pop();
    }

    private void overFirstToSecond(Stack<Integer> stack1, Stack<Integer> stack2) {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }
}
