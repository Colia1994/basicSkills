package org.kly.algorithms.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author konglingyao
 * @Date 2023/5/16
 */
public class h_1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int length = jobDifficulty.length;
        if (d > length) {
            return -1;
        }
        int[][] f = new int[d + 1][length];
        Map<String, Integer> maxRangeMap = new HashMap<>();
        //初始化数据 辅助状态转移方程成立
        for (int y = 0; y < length ; y++) {
            f[1][y] = maxRangeValue(0,y,jobDifficulty,maxRangeMap);
        }
        for (int i = 2; i <= d; i++) {
            for (int j = i - 1; j < length; j++) {
                f[i][j] = minF(f, i, j, jobDifficulty, maxRangeMap);
            }
        }
        return f[d][jobDifficulty.length - 1];
    }

    private int minF(int[][] f, int i, int j, int[] jobDifficulty, Map<String, Integer> maxRangeMap) {
        if (j == 0) {
            return maxRangeValue(j, j, jobDifficulty, maxRangeMap);
        }
        int min = Integer.MAX_VALUE;
        for (int y = i - 1; y <= j; y++) {
            int value = f[i - 1][y-1] + maxRangeValue(y , j, jobDifficulty, maxRangeMap);
            min = Math.min(min, value);
        }
        return min;
    }

    private int maxRangeValue(int start, int end, int[] jobDifficulty, Map<String, Integer> maxRangeMap) {
        String key = start + "," + end;
        if (start == end) {
            maxRangeMap.put(key, jobDifficulty[end]);
            return jobDifficulty[end];
        } else {
            String preKey = start + "," + (end - 1);
            Integer preMax = maxRangeMap.get(preKey);
            if (null != preMax) {
                maxRangeMap.put(key, Math.max(preMax, jobDifficulty[end]));
                return Math.max(preMax, jobDifficulty[end]);
            } else {
                int max = 0;
                for (; start <= end; start++) {
                    max = Math.max(max, jobDifficulty[start]);
                }
                maxRangeMap.put(key, max);
                return max;
            }
        }
    }

    //官方默认解法和我一样 区别在于算f(x,y)我是用map节省运算，其实效果不大，官方直接扫描数组
    //第二个 我的minF 可以优化 简化后就是官方样子
    public int minDifficulty_gf_1(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[][] dp = new int[d + 1][n];
        for (int i = 0; i <= d; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        int ma = 0;
        for (int i = 0; i < n; ++i) {
            ma = Math.max(ma, jobDifficulty[i]);
            dp[0][i] = ma;
        }
        for (int i = 1; i < d; ++i) {
            for (int j = i; j < n; ++j) {
                ma = 0;
                for (int k = j; k >= i; --k) {
                    ma = Math.max(ma, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], ma + dp[i - 1][k - 1]);
                }
            }
        }
        return dp[d - 1][n - 1];
    }

    public int minDifficulty_gf_2(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[] dp = new int[n];
        for (int i = 0, j = 0; i < n; ++i) {
            j = Math.max(j, jobDifficulty[i]);
            dp[i] = j;
        }
        for (int i = 1; i < d; ++i) {
            int[] ndp = new int[n];
            Arrays.fill(ndp, 0x3f3f3f3f);
            for (int j = i; j < n; ++j) {
                int ma = 0;
                for (int k = j; k >= i; --k) {
                    ma = Math.max(ma, jobDifficulty[k]);
                    ndp[j] = Math.min(ndp[j], ma + dp[k - 1]);
                }
            }
            dp = ndp;
        }
        return dp[n - 1];
    }

}
