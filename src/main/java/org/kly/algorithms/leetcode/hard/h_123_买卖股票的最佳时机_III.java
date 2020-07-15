package org.kly.algorithms.leetcode.hard;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/10
 */
public class h_123_买卖股票的最佳时机_III {

    /**
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * max(   选择 rest  ,             选择 sell      )
     * <p>
     * 解释：今天我没有持有股票，有两种可能：
     * 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
     * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
     * <p>
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * max(   选择 rest  ,           选择 buy         )
     * <p>
     * 解释：今天我持有着股票，有两种可能：
     * 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
     * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * <p>
     * dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
     * dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
     * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     * dp[i][1][1] = max(dp[i-1][1][1], -prices[i])
     */
    public int maxProfit(int[] prices) {
        if(prices.length<=0){
            return 0;
        }
        int[][][] dp = new int[prices.length][3][2];
        //没有购买次数 你咋都是不赚钱
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
        }
        return dp[prices.length - 1][2][0];
    }



}
