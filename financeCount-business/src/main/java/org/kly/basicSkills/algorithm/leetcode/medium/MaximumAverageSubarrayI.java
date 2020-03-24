package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 643. Maximum Average Subarray I
 * <p>
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 * @author colia
 * @date 2018/12/16 0:39
 */
public class MaximumAverageSubarrayI {

    /**
     *
     */
    public static double findMaxAverage(int[] nums, int k) {
        double num = -Double.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int total = 0;
            double numIn;
            for (int j = i; j < i + k; j++) {
                total += nums[j];
            }
            double totalD = (double) total;
            numIn = totalD / k;

            num = Math.max(num, numIn);

        }
        return num;
    }

    /**
     * solution
     */
    public double findMaxAverageSolution(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = sum[i - 1] + nums[i];
        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return res;
    }

    public double findMaxAverage2(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return res / k;
    }

}
