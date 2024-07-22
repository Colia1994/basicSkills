package org.kly.algorithms.leetcode.medium;

/**
 * @author konglingyao
 * @date 2024/7/22
 */
public class m_209 {

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int minLength = Integer.MAX_VALUE;
        int nowCount = 0;
        while (i < nums.length && j < nums.length) {
            if (nowCount < target && nowCount + nums[j] < target) {
                nowCount += nums[j];
                j++;
            } else if (nowCount < target && nowCount + nums[j] >= target) {
                minLength = Math.min(minLength, j - i + 1);
                nowCount += nums[j];
                while (nowCount > target && nowCount - nums[i] >= target) {
                    nowCount -= nums[i];
                    i++;
                    minLength = Math.min(minLength, j - i + 1);
                }
                j++;
            } else if (nowCount >= target) {
                if (nums[i] <= nums[j]) {
                    nowCount += nums[j];
                    while (nowCount > target && nowCount - nums[i] >= target) {
                        nowCount -= nums[i];
                        i++;
                        minLength = Math.min(minLength, j - i + 1);
                    }
                    j++;
                } else if (nums[i] > nums[j]) {
                    //下一轮初始化
                    nowCount -= nums[i];
                    i++;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public int minSubArrayLen_enhance(int target, int[] nums) {
        int i = 0, j = 0;
        int minLength = Integer.MAX_VALUE;
        int nowCount = 0;
        while (i < nums.length && j < nums.length) {

            nowCount += nums[j];
            while (nowCount >= target) {
                minLength = Math.min(minLength, j - i + 1);
                nowCount -= nums[i];
                i++;
            }
            j++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


    public static void main(String[] args) {
        int[] input = new int[]{10, 2, 3};
        m_209 m = new m_209();
        System.out.println(m.minSubArrayLen(6, input));
    }

}
