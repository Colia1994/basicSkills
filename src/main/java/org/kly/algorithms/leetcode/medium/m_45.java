package org.kly.algorithms.leetcode.medium;

import java.util.Arrays;

public class m_45 {


    /**
     * dp[]
     * dp1[minStep] = Math.min(dp1[x] + nums[x])
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dpMinSteps = new int[n];
        Arrays.fill(dpMinSteps, Integer.MAX_VALUE);
        dpMinSteps[0] = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = j; i <= j + nums[j] && i < n; i++) {
                dpMinSteps[i] = Math.min(dpMinSteps[j] + 1, dpMinSteps[i]);
            }
            if (j + nums[j] >= n-1) {
                return dpMinSteps[j] + 1;
            }
        }
        return dpMinSteps[n - 1];
    }


    /**
     * dp[]
     * dp1[minStep] = Math.min(dp1[x] + nums[x])
     * 优化 贪心，直接跳到当前最远位置 无需存储dp
     */
    public int jump_1(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        int step =0;
        int end = 0;
        for (int j = 0; j < n - 1; j++) {
            maxIndex = Math.max(maxIndex, j + nums[j]);
            //跳跃到 当前最远  则 把当前最远距离更新
            if(j == end) {
                end = maxIndex;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        m_45 m = new m_45();
        System.out.println(m.jump(nums));

    }
}
