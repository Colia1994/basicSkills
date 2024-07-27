package org.kly.algorithms.leetcode.medium;

import java.util.*;

public class m_253 {

    public int minMeetingRooms(int[][] intervals) {


        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        // 最小堆
        PriorityQueue<Integer> allocator = new PriorityQueue<>(
                intervals.length, Comparator.comparingInt(a -> a));
        int count = 0;
        for (int[] interval : intervals) {
            if (null == allocator.peek() || allocator.peek() > interval[0]) {
                count++;
                //开会议室
            } else {
                //复用会议室 更新最小堆
                allocator.poll();
            }
            allocator.offer(interval[0]);

        }
        return count;
    }
}
