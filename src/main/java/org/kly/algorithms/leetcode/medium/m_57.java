package org.kly.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class m_57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        boolean hasInsert = false;
        boolean needCheck = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] in = intervals[i];
            if (hasInsert && !needCheck) {
                list.add(in);
                continue;
            } else if (!hasInsert) {
                if (in[1] < newInterval[0]) {
                    //直接写入
                    list.add(in);
                    continue;
                } else if (in[0] > newInterval[1]) {
                    //插入
                    list.add(newInterval);
                    hasInsert = true;
                    list.add(in);
                    continue;
                } else {
                    //合并
                    int min = Math.min(in[0], newInterval[0]);
                    int max = Math.max(in[1], newInterval[1]);
                    list.add(new int[]{min, max});
                    //
                    // 并且后续需要检查 直到没有交集
                    hasInsert = true;
                    needCheck = true;
                }
            } else if (hasInsert && needCheck) {
                //需要检查前序 是否合当前有交集
                int[] pre = list.get(list.size() - 1);
                if (pre[1] < in[0]) {
                    needCheck = false;
                    list.add(in);
                } else {
                    pre[1] = Math.max(in[1],pre[1]);
                }
                continue;
            }
        }

        if(!hasInsert){
            list.add(newInterval);
        }
        return list.toArray(new int[list.size()][]);
    }
}
