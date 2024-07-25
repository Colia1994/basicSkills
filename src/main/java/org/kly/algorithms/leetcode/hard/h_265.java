package org.kly.algorithms.leetcode.hard;

/**
 * @author konglingyao
 * @date 2024/7/25
 */
public class h_265 {

    public int minCostII(int[][] costs) {

        int n = costs.length;
        int k = costs[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int nowMinCost = Integer.MAX_VALUE;
                for (int x = 0; x < k; x++) {
                    if (x != j) {
                        nowMinCost = Math.min(nowMinCost, costs[i - 1][x]);
                    }

                }
                costs[i][j] += nowMinCost;
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int x = 0; x < k; x++) {
            minCost = Math.min(minCost, costs[n - 1][x]);
        }

        return minCost;
    }


    public static void main(String[] args) {
        int[][] array = {
                {3, 20, 7, 7, 16, 8, 7, 12, 11, 19, 1},
                {10, 14, 3, 3, 9, 13, 4, 12, 14, 13, 1},
                {10, 1, 14, 11, 1, 16, 2, 7, 16, 7, 19},
                {13, 20, 17, 15, 3, 13, 8, 10, 7, 8, 9},
                {4, 14, 18, 15, 11, 9, 19, 3, 15, 12, 15},
                {14, 12, 16, 19, 2, 12, 13, 3, 11, 10, 9},
                {18, 12, 10, 16, 19, 9, 18, 4, 14, 2, 4}
        };
        h_265 h = new h_265();
        System.out.println(h.minCostII(array));
    }

}
