package org.kly.algorithms.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/3/17.
 */
public class e_225_用队列实现栈 {

    class MyStack {

        Queue<Integer> inQ = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (inQ.size() == 0) {
                inQ.offer(x);
            } else {
                Queue<Integer> outQ = new LinkedList<>();
                while (inQ.peek() != null) {
                    outQ.add(inQ.poll());
                }
                inQ.offer(x);
                while (outQ.peek() != null) {
                    inQ.add(outQ.poll());
                }
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return inQ.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return inQ.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return inQ.size() == 0;
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
