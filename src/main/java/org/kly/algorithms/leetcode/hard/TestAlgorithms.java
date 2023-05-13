package org.kly.algorithms.leetcode.hard;

import java.util.*;

/**
 * @Author konglingyao
 * @Date 2023/5/8
 */
public class TestAlgorithms {

    public static void main(String[] args) {
        TestAlgorithms testAlgorithms = new TestAlgorithms();
        System.out.println(testAlgorithms.findMaxK(new int[]{-1, 2, -3, 3}));
    }


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
