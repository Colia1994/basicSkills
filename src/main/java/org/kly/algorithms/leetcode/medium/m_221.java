package org.kly.algorithms.leetcode.medium;

public class m_221 {

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            max = Math.max(max, dp[0][j]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                if (matrix[i][j] == '1') {


                    int x = dp[i][j - 1];
                    int y = dp[i - 1][j];
                    int z = dp[i-1][j-1];
                    dp[i][j] =Math.min( Math.min(x,y),z) +1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;

    }
}
