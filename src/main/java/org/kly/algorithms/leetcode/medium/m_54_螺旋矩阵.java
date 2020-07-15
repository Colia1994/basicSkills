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
public class m_54_螺旋矩阵 {

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



    public static void main (String[] args){
        int[] i = new int[10];
        System.out.println(i.length);
    }


}
