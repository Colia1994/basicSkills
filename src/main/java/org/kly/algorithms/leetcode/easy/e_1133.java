package org.kly.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class e_1133 {

    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);


        }
        int max = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                max = Math.max(max, entry.getKey());
            }

        }

        return max;
    }
}
