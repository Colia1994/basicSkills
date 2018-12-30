package org.kly.basicSkills.algorithm.toOffer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author colia
 * @date 2018/12/30 23:21
 */
public class 顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (matrix == null) {
            return arrayList;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;

        while (m > 2 * start && n > 2 * start) {
            int endM = m - start - 1;
            int endN = n - start - 1;

            for (int i = start; i <= endM; i++) {
                arrayList.add(matrix[start][i]);
            }
            for (int i = start + 1; i <= endN; i++) {
                arrayList.add(matrix[i][endM]);
            }
            if (endN > start) {
                for (int i = endM-1; i >= start; i--) {
                    arrayList.add(matrix[endN][i]);
                }
            }
            if (endM > start) {
                for (int i = endN - 1; i >= start + 1; i--) {
                    arrayList.add(matrix[i][start]);
                }
            }
            start++;
        }
        return arrayList;
    }
}
