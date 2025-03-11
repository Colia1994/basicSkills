package org.kly.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @Author konglingyao
 * @Date 2020/6/5 10:53 上午
 */
public class m_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }


        //一圈圈打印，每一圈按顺序打印对应行列数据，注意转弯的边界值控制
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        while (count < (Math.min(m, n) + 1) / 2) {


            //第一行
            for (int i = count, j = count; j < n - count; j++) {
                result.add(matrix[i][j]);
            }
            //最后一列
            for (int i = count + 1, j = n - count - 1; i < m - count; i++) {
                result.add(matrix[i][j]);
            }
            //最后一行
            for (int i = m - count - 1, j = n - count - 2; j >= count; j--) {
                if (m - count - 1 == count) {
                    break;
                }
                result.add(matrix[i][j]);
            }
            //第一列
            for (int i = m - count - 2, j = count; i > count; i--) {
                if (n - count - 1 == count) {
                    break;
                }
                result.add(matrix[i][j]);
            }

            count++;
        }

        return result;
    }

    /**
     * 2025-03-10 重写
     */
    public static List<Integer> spiralOrder20250310(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int leftY = 0, topX = 0, rightY = matrix[0].length - 1, underX = matrix.length - 1;

        int x = 0, y = 0;
        while (res.size() < (matrix.length) * (matrix[0].length)) {
            //第一行 x不变 移动y
            for (; y <= rightY && y >= leftY && x <= underX && x >= topX;
                 y++) {
                res.add(matrix[x][y]);
            }
            topX++;
            //最后一列
            y--;
            x++;
            for (; y <= rightY && y >= leftY && x <= underX && x >= topX; x++) {
                res.add(matrix[x][y]);
            }
            x--;
            y--;
            rightY--;
            //最后一行 反方向
            for (; y <= rightY && y >= leftY && x <= underX && x >= topX; y--) {
                res.add(matrix[x][y]);
            }
            y++;
            x--;
            underX--;
            //第一列 反方向
            for (; y <= rightY && y >= leftY && x <= underX && x >= topX; x--) {
                res.add(matrix[x][y]);
            }
            x++;
            y++;
            leftY++;
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] intNum = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        m_54.spiralOrder20250310(intNum);
    }


}
