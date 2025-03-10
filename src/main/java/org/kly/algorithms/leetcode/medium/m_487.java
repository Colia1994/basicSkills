package org.kly.algorithms.leetcode.medium;

import javafx.util.Pair;

/**
 * @author konglingyao
 * @date 2024/7/28
 */
public class m_487 {

    /**
     * nums = [1,0,1,1,0,1]
     */
    public int findMaxConsecutiveOnes(int[] nums) {

        int zeroCount = 0;
        int left = 0, right = 0;
        int max = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            right++;
            if (zeroCount <= 1) {
                max = Math.max(max, right - left);
            }

            while (zeroCount > 1) {
                //移动left
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        m_487 m = new m_487();
        System.out.println(m.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }
}
