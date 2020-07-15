package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 48. Rotate Image
 * <p>
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * Example 1:
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @author colia
 * @date 2019/2/20 22:32
 */
public class m_48_旋转图像 {

    /**
     * my solution
     */
    public void rotate(int[][] matrix) {
        // 翻转 90° = 先关于 X 轴对称翻转 + 再关于对角线翻转
        for (int i = 0; i < matrix.length / 2; i++) {
            swap(matrix, i, matrix.length - i - 1);
        }
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < x; y++) {
                swap(matrix, x, y, y, x);
            }
        }
    }

    private void swap(int[][] matrix, int r1, int r2) {
        int[] temp = matrix[r1];
        matrix[r1] = matrix[r2];
        matrix[r2] = temp;
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}
