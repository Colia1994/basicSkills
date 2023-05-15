package org.kly.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class e_2441 {

    public int findMaxK(int[] nums) {
        int max = -1;
        Map<Integer, Integer> imap = new HashMap<>();
        for (int i : nums) {
            imap.put(i, i);
            int diff = -i;
            Integer r = imap.get(diff);
            if (r != null) {
                max = Math.max(max, Math.abs(i));
            }
        }

        return max;
    }
}
