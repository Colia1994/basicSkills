package org.kly.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class e_1086 {

    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] item : items) {
            int num = item[0], score = item[1];
            if (map.containsKey(num)) {
                map.get(num).offer(score);
            } else {
                PriorityQueue<Integer> que = new PriorityQueue<Integer>(5, (a, b) -> b - a);
                que.offer(score);
                map.put(num, que);
            }
        }

        int[][] res = new int[map.size()][2];
        int index = 0;

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int sum = 0;
            PriorityQueue<Integer> queue = entry.getValue();
            int count = 5;
            while (count-- > 0) {
                sum += queue.poll();
            }
            res[index++] = new int[]{entry.getKey(), sum / 5};
        }

        return res;
    }


}
