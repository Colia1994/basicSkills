package org.kly.leetcode.medium;

/**
 * 59. Spiral Matrix II
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @author colia
 * @date 2018/12/17 0:47
 */
public class SpiralMatrixII {
    /**
     * my first answer
     */
    public int[][] generateMatrix(int n) {


        int[][] resultArray = new int[n][n];
        if(n ==1){
            resultArray[0][0] = 1;
            return resultArray;
        }
        int directionLeftRight = 1;
        int directionUpDown = 0;
        int j = 0, k = 0;
        int value = 1;
        while (resultArray[j][k] ==0) {
            resultArray[j][k] = value;
            value++;
            j += directionUpDown;
            k += directionLeftRight;
            if (j >= n || k >= n || j < 0 || k < 0 || resultArray[j][k] != 0) {
                //边界警告 需要转向
                //还原
                j -= directionUpDown;
                k -= directionLeftRight;
                int newLR = redirection(directionLeftRight, directionUpDown, true);
                directionUpDown = redirection(directionLeftRight, directionUpDown, false);
                directionLeftRight = newLR;
                j += directionUpDown;
                k += directionLeftRight;
            }
        }
        return resultArray;

    }

    private int redirection(int leftright ,int updown, boolean lu) {

        if (leftright == 1 && updown == 0) {
            return lu ? 0 : 1;
        } else if (leftright == 0 && updown == 1) {
            return lu ? -1 : 0;
        } else if (leftright == -1 && updown == 0) {
            return lu ? 0 : -1;

        } else if (leftright == 0 && updown == -1) {
            return lu ? 1 : 0;
        }
        return 0;
    }

    /**
     * 上述答案精简思路
     */
    public int[][] generateMatrix1(int n) {
        int[][] arr = new int[n][n];
        int c = 1, j = 0;
        while (c <= n * n) {

            for (int i = j; i < n - j; i++)
                arr[j][i] = c++;
            for (int i = j + 1; i < n - j; i++)
                arr[i][n - j - 1] = c++;
            for (int i = n - j - 2; i >= j; i--)
                arr[n - j - 1][i] = c++;
            for (int i = n -j - 2; i > j; i--)
                arr[i][j] = c++;

            j++;
        }

        return arr;
    }

    /**
     * 环形递增填数
     */
    private static int[][] asd(int m ,int n) {
        int[][] asd1 = new int[m][n];
        int j = 0;
        int value = 1;
        int count = 0;
        while (count < m * n) {
            for (int i = j; i < n - j; i++) {
                asd1[j][i] = value;
                count += 1;
            }
            value++;
            for (int i = j +1; i < m - j; i++) {
                asd1[i][n - j - 1] = value;
                count += 1;

            }
            value++;
            for (int i = n - j - 2; i >= j; i--) {
                asd1[m - j - 1][i] = value;
                count += 1;

            }
            value++;
            for (int i = m - j - 2; i > j; i--) {
                asd1[i][j] = value;
                count += 1;
            }
            value++;
            j++;
        }

        return asd1;
    }





}
