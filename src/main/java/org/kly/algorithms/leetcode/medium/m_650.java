package org.kly.algorithms.leetcode.medium;

/**
 * @author konglingyao
 * @date 2024/7/17
 */
public class m_650 {

    //dp 分解题目后，发现质数直接返回，非质数要求判断约数并取最小
    public int minSteps_dp(int n) {
        //质数的fn =n
        //非质数则 fn = min(fx + n/x)

        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }

    public int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n > 1) {
            ans += n;
        }
        return ans;

    }

    public static void main(String[] args) {
        m_650 m = new m_650();
        System.out.println(m.minSteps_dp(6));
    }
}
