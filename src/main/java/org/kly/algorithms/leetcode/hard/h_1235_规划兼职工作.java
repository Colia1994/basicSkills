package org.kly.algorithms.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 * <p>
 * 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
 * <p>
 * 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
 * <p>
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 * <p>
 * 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
 * <p>
 *  输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * 输出：120
 * 解释：
 * 我们选出第 1 份和第 4 份工作，
 * 时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/6
 */
public class h_1235_规划兼职工作 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

        //截止第i个job 最大利润
        int[] dp = new int[n + 1];
        //第i个job前一个job
        int[] preJob = new int[n + 1];

        dp[0] = 0;
        preJob[0] = 0;
        dp[1] = jobs[0][2];
        preJob[1] = 0;
        for (int i = 2; i <= n; i++) {

            for (int j = i - 1; j > 0; j--) {
                if (jobs[j - 1][1] <= jobs[i - 1][0]) {
                    preJob[i] = j;
                    break;
                }
            }

        }
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[preJob[i]] + jobs[i - 1][2]);
        }
        return dp[n];
    }

    //[1,2,4,6,3]
    //[3,5,6,9,10]
    //[20,20,70,60,100]
    // prejob 0 0 1 3 1
    public static void main(String[] args) {
        h_1235_规划兼职工作 h = new h_1235_规划兼职工作();
        h.jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60});
    }
}
