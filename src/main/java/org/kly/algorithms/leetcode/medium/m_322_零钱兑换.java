package org.kly.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/3/17.
 */
public class m_322_零钱兑换 {

    /**
     * 合为amount最小硬币数目 为 min(dp[amount-1] ,dp[amount-2],dp[amount-5])
     * dp[11]  min(dp[10],dp[9],[6]) + 1
     * 0 1 2 3 4 5 6 7 8 9 10 11
     * 0 1 1 2 2 1 2 2 3 3 2 3
     *
     * @param coins  硬币集合
     * @param amount 合
     * @return 最小次数
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        //全部填充最大值，1为了min函数不被0取到，2 为了找到万一不存在匹配的场景
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        m_322_零钱兑换 m = new m_322_零钱兑换();
        m.coinChange(new int[]{1, 2, 5}, 11);
    }


}
