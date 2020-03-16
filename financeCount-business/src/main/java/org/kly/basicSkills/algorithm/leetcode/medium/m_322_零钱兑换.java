package org.kly.basicSkills.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Colia
 * @Date 2020/3/17.
 */
public class m_322_零钱兑换 {

    /**
     * 其中 c_jc
     * j
     * ​
     *   代表的是第 jj 枚硬币的面值，即我们枚举最后一枚硬币面额是 c_jc
     * j
     * ​
     *  ，那么需要从 i-c_ji−c
     * j
     * ​
     *   这个金额的状态 F(i-c_j)F(i−c
     * j
     * ​
     *  ) 转移过来，再算上枚举的这枚硬币数量 11 的贡献，由于要硬币数量最少，所以 F(i)F(i) 为前面能转移过来的状态的最小值加上枚举的硬币数量 11 。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param coins 硬币集合
     * @param amount 合
     * @return 最小次数
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
