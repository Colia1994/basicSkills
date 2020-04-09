package org.kly.basicSkills.algorithm.wild;

import java.util.HashMap;

/**
 * * [
 * <p>
 * [1,  2,  3,  4,  5,  6],
 * <p>
 * [11, 23, 35, 345],
 * <p>
 * [34,  4,  65]
 * <p>
 * ]
 * <p>
 * // 1,2,11,3,23, 34，4, 。。。。
 * <p>
 * <p>
 * 00
 * 01 10
 * 02 11 20
 * 03 12 21 30
 * 04 13
 *
 * @author colia
 * @date 2020/2/3 17:45
 */
public class 斜对角线打印 {

    private static int[][] array = new int[][]{{1}, {11, 23, 35, 345}, {34, 4, 65}};

    private static void print(int[][] a) {
        int n = 0, max = 0;
        for (int le = 0; le < a.length; le++) {
            max = Math.max(max, a[le].length + le);
        }
        while (n < max) {
            int i = 0;
            int j = n;
            while (i <= n) {
                if (i < a.length && j < a[i].length) {
                    System.out.print(a[i][j] + ",");
                }
                i++;
                j--;
            }
            n++;
        }

    }


    public static void main(String[] args) {
//        print(array);
//        CollectionUtils.;
        HashMap<String, String> newh = new HashMap<>();
        newh.put(null, null);
        if (newh.isEmpty()) {
            System.out.print("assssssssssssss");
        }
    }
}
