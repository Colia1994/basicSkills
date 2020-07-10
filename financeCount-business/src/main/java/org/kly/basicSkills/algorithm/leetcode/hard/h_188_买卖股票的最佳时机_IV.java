package org.kly.basicSkills.algorithm.leetcode.hard;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 * <p>
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/10
 */
public class h_188_买卖股票的最佳时机_IV {
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
     */
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        if (n <= 0 || k == 0) {
            return 0;
        }

        //没有购买次数 你咋都是不赚钱
        //还没开始就持有 亏钱
        //k大于一半，则理解为无限
        if (k > n / 2) {
            return maxProfit2(prices);
        }
        int[][][] dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        h_188_买卖股票的最佳时机_IV h = new h_188_买卖股票的最佳时机_IV();
        h.maxProfit(1, new int[]{2, 4, 1});
    }

    public int maxProfit1(int k, int[] prices) {
        if (k == 0) return 0;
        int n = prices.length;
        if (k > prices.length / 2) return maxProfit2(prices);
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            // base case
            dp[i][0][0] = 0;//至今为止没有交易，收益为0
            dp[i][0][1] = Integer.MIN_VALUE;//交易了0次，但持有股票，不符合规则
            for (int t = 1; t <= k; t++) {
                // base case
                if (i == 0) {
                    dp[i][t][0] = 0;//第一天买入t次，当天卖出t次,收入为0
                    dp[i][t][1] = -prices[i];//甭管第一天买多少次，反正最后少卖一次，持有了股票
                    continue;
                }
                dp[i][t][0] = Math.max(dp[i - 1][t][0], dp[i - 1][t][1] + prices[i]);
                dp[i][t][1] = Math.max(dp[i - 1][t][1], dp[i - 1][t - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }


}
