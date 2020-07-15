package org.kly.basicSkills.algorithm.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/6/30
 */
public class 剑指Offer09用两个栈实现队列 {

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    class CQueue {

        private Deque<Integer> s1 ;
        private Deque<Integer> s2 ;


        public CQueue() {
            s1 = new LinkedList<>();
            s2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            while(!s1.isEmpty()){
                s2.add(s1.pop());
            }
            s2.add(value);
            while(!s2.isEmpty()){
                s1.add(s2.pop());
            }
        }

        public int deleteHead() {
            if(s1.isEmpty()){
                return -1;
            }
            return s1.pop();
        }
    }


}
