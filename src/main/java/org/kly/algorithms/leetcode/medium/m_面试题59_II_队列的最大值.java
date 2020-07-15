package org.kly.algorithms.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/3/17.
 */
public class m_面试题59_II_队列的最大值 {

    /**
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     */
    class MaxQueue {

        Queue<Integer> queue = new LinkedList<>();

        Deque<Integer> deque = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            return deque.size() > 0 ? deque.peekFirst() : -1;
        }

        public void push_back(int value) {
            queue.offer(value);
            while (deque.size() > 0 && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.offerLast(value);
        }

        public int pop_front() {
            int tmp = queue.size() > 0 ? queue.poll() : -1;
            if (deque.size() > 0 && tmp == max_value()) {
                deque.pollFirst();
            }
            return tmp;
        }
    }


}
