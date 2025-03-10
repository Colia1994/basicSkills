package org.kly.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class e_1426 {

    public int countElements(int[] arr) {
        Map<Integer, Boolean> map = new HashMap<>();

        int count = 0;
        for (int i : arr) {
            map.put(i, true);
        }
        for (int i : arr) {
            if (map.containsKey(i+1) && map.get(i + 1)) {
                count++;
            }
        }

        return count;
    }
}
