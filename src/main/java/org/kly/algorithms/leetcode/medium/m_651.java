package org.kly.algorithms.leetcode.medium;

/**
 * @author konglingyao
 * @date 2024/7/25
 */
public class m_651 {

    /**
     * dp[i] 按i次最多的a数量
     * dp[i] = dp[i-1] + i
     */

    public int maxA(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int counts = dp[i - 1] + 1;
            for (int j = 0; j < i - 2; j++) {
                counts = Math.max(counts, dp[j] + dp[j] * (i - j - 2));
            }
            dp[i] = counts;
        }
        return dp[n];
    }

}
