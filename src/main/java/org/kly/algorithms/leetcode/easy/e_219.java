package org.kly.algorithms.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class e_219 {

    /**
     * 两个 不同的索引 i j
     *
     * @param nums [1,2,2,4,3,3,3]
     * @param k    3 abs(i-j)<=3
     * @return true
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1 || k == 0) return false;

        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        int left = 0;
        int right = 1;
        while (right < nums.length) {

            if (set.contains(nums[right])) {
                return true;
            } else {
                set.add(nums[right]);
            }
            right++;
            while (set.size() > k) {
                //需要移除left
                set.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}
