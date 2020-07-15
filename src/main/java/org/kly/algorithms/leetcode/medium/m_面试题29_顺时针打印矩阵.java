package org.kly.algorithms.leetcode.medium;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/6/5 2:13 下午
 */
public class m_面试题29_顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        //一圈圈打印，每一圈按顺序打印对应行列数据，注意转弯的边界值控制
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];

        int count = 0;
        int xb = 0;
        while (count < (Math.min(m, n) + 1) / 2) {


            //第一行
            for (int i = count, j = count; j < n - count; j++) {
                result[xb] = matrix[i][j];
                xb++;
            }
            //最后一列
            for (int i = count + 1, j = n - count - 1; i < m - count; i++) {
                result[xb] = matrix[i][j];
                xb++;
            }
            //最后一行
            for (int i = m - count - 1, j = n - count - 2; j >= count; j--) {
                if (m - count - 1 == count) {
                    break;
                }
                result[xb] = matrix[i][j];
                xb++;
            }
            //第一列
            for (int i = m - count - 2, j = count; i > count; i--) {
                if (n - count - 1 == count) {
                    break;
                }
                result[xb] = matrix[i][j];
                xb++;
            }

            count++;
        }

        return result;
    }
}
