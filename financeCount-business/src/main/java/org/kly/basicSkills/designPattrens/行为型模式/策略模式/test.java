package org.kly.basicSkills.designPattrens.行为型模式.策略模式;

import org.springframework.util.comparator.Comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author konglingyao
 * @Date 2020/7/7
 */
public class test {

    public void jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs1 = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs1[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs1, Comparator.comparingInt(a -> a[1]));
    }
}
