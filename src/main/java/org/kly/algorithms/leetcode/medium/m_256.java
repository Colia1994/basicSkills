package org.kly.algorithms.leetcode.medium;

/**
 * @author konglingyao
 * @date 2024/7/25
 */
public class m_256 {

    public int minCost(int[][] costs) {
        //房子数量
        int n = costs.length;
        //
        for (int i = 1; i < n; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        return Math.min(Math.min(costs[n - 1][1], costs[n - 1][2]), costs[n - 1][0]);
    }
}
