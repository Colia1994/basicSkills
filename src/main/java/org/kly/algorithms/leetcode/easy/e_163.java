package org.kly.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class e_163 {

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        int start = lower;
        int end = upper;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > start) {
                List<Integer> res1 = new ArrayList<>();
                res1.add(start);
                res1.add(nums[i] - 1);
                res.add(res1);
            }
            start = nums[i] + 1;
        }
        if (start <= end) {
            List<Integer> res2 = new ArrayList<>();
            res2.add(start);
            res2.add(end);
            res.add(res2);
        }
        return res;

    }
}
