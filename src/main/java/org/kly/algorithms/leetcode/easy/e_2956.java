package org.kly.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author konglingyao
 * @date 2024/7/16
 */
public class e_2956 {

    /**
     * answer1：使得 nums1[i] 在 nums2 中出现的下标 i 的数量。
     * answer2：使得 nums2[i] 在 nums1 中出现的下标 i 的数量。
     */
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            if (map1.containsKey(num)) {
                map1.put(num, map1.get(num) + 1);
            } else {
                map1.put(num, 1);
            }
        }
        for (int num2 : nums2) {
            if (map1.containsKey(num2)) {
                j++;
                i += map1.get(num2);
                map1.put(num2, 0);
            }
        }
        return new int[]{i, j};
    }

}
