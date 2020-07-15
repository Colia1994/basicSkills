package org.kly.algorithms.leetcode.medium;

/**
 * @Author Colia
 * @Date 2020/4/7.
 */
public class m_面试题_01_07_旋转矩阵 {

    public void rotate(int[][] matrix) {
        int m = matrix.length;

        int level = (m + 1) / 2;
        int x = 0;

        while (level > 0) {

            for (int y = x; y < m - x - 1; y++) {
                int r_u = matrix[x][y];
                matrix[x][y] = matrix[m - y - 1][x];
                matrix[m - y - 1][x] = matrix[m - x - 1][m - y - 1];
                matrix[m - x - 1][m - y - 1] = matrix[y][m - x - 1];
                matrix[y][m - x - 1] = r_u;
            }
            x++;
            level--;
        }
        //输出
        //[[15,13,9,5],[2,3,4,1],[12,6,8,7],[16,14,10,11]]
        //预期结果
        //[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    }
}
