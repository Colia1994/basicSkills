package org.kly.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @Author Colia
 * @Date 2020/3/13.
 */
public class e_169_多数元素 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i : nums) {
            if (numMap.containsKey(i)) {
                int count = numMap.get(i) + 1;
                if (count > nums.length / 2) {
                    return i;
                }
                numMap.put(i, count);
            } else {
                numMap.put(i, 1);
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        e_169_多数元素 e = new e_169_多数元素();
        System.out.println(e.majorityElement(new int[]{3, 2, 3}));
    }
}
