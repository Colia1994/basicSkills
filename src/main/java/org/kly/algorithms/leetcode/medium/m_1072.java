package org.kly.algorithms.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author konglingyao
 * @Date 2023/5/15
 */
public class m_1072 {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        //完全相同 和完全相反的计数
        Map<String, Integer> imap = new HashMap<>();
        int max = 1;
        for (int[] column : matrix) {
            String key = convert2String(column);
            Integer value = imap.get(key);
            if (null == value) {
                imap.put(key, 1);
            } else {
                value++;
                max = Math.max(max, value);
                imap.put(key, value);
            }
        }
        return max;
    }

    private String convert2String(int[] column) {
        boolean cv = column[0] == 0;

        StringBuilder sb = new StringBuilder();
        for (int a : column) {
            sb.append(cv ? 1 - a : a);
        }
        return sb.toString();
    }


    /**
     * 理论上是对的 有几个case超时了 因为时间复杂度是 ologn 可以借助空间来优化为on
     *
     * @param matrix
     * @return
     */
    public int maxEqualRowsAfterFlips_1(int[][] matrix) {
        //找到不同行存在异或或者完全相同的数量，最多的就是列翻转后的想同列最多数量 这里不考虑翻转次数
        int max = 1;

        for (int y = 0; y < matrix.length; y++) {
            int c_max = 0;
            for (int y_1 = y; y_1 < matrix.length; y_1++) {
                if (check_1(matrix[y], matrix[y_1])) {
                    c_max++;
                }
            }
            max = Math.max(max, c_max);
        }
        return max;
    }

    private boolean check_1(int[] a, int[] b) {
        boolean res = true;
        for (int i = 0; i < a.length; i++) {
            res &= a[i] != b[i];
        }
        return Objects.equals(Arrays.toString(a), Arrays.toString(b)) || res;
    }
}
