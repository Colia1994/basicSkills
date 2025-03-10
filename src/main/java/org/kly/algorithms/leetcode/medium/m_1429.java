package org.kly.algorithms.leetcode.medium;

import java.util.*;

public class m_1429 {

    class FirstUnique {

        Queue<Integer> q;

        Map<Integer, Boolean> map;

        public FirstUnique(int[] nums) {
            q = new LinkedList<>();
            map = new HashMap<>();
            for (int i : nums) {
                this.add(i);
            }
        }

        public int showFirstUnique() {
            //为了o1找到，需要移除对列头部不唯一的值，因为题目不需要查询队列
            while(!q.isEmpty() && !map.get(q.peek())) {
                q.poll();
            }

            if(q.isEmpty()) return -1;
            return q.peek();
        }

        public void add(int value) {
            q.add(value);
            //存在则不唯一
            if (map.containsKey(value)) {
                map.put(value, false);
            } else {
                //不存在 第一次写入 则唯一
                map.put(value, true);
            }
        }
    }
}
