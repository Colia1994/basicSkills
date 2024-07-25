package org.kly.algorithms.leetcode.easy;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @Author Colia
 * @Date 2020/3/9.
 */
public class e_121 {

    //通俗理解
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int i = 0, j = 0, profit = 0;
        while (j < length) {
            if (prices[j] - prices[i] > profit) {
                profit = prices[j] - prices[i];
            }
            if (prices[j] < prices[i]) {
                i++;
            }
            j++;

        }

        return profit;
    }

    /**
     * dp[天][买入次数][0未持有 1持有]
     * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     * dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]) = max(dp[i-1][1][1], -prices[i])
     * 解释：k = 0 的 base case，所以 dp[i-1][0][0] = 0。
     * <p>
     * 现在发现 k 都是 1，不会改变，即 k 对状态转移已经没有影响了。
     * 可以进行进一步化简去掉所有 k：
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], -prices[i])
     */
    public int maxProfit1(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    //dp优化
    public int maxProfit2(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

}
