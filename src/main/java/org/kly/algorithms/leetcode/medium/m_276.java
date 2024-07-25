package org.kly.algorithms.leetcode.medium;

/**
 * @author konglingyao
 * @date 2024/7/25
 */
public class m_276 {


    /**
     * dp[i][0] = sum(dp[i-1][] + k,)
     */
    public int numWays(int n, int k) {
        int[] dp = new int[n + 2];
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        m_276 obj = new m_276();
        System.out.println(obj.numWays(1, 1));
    }
}
