package org.kly.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author konglingyao
 * @date 2024/7/28
 */
public class m_1198 {

    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();

        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < n; i++) {
            map.put(mat[0][i], 1);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(mat[i][j])) {
                    map.put(mat[i][j], map.get(mat[i][j]) + 1);
                }
            }
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == m) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
