package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * @Author Colia
 * @Date 2020/3/14.
 */
public class m_300_最长上升子序列 {


    /**
     * 定义 dp[i]dp[i] 为考虑前 ii 个元素，以第 ii 个数字结尾的最长上升子序列的长度，注意 nums[i] 必须被选取。
     * <p>
     * 我们从小到大计算 dp[]dp[] 数组的值，在计算 dp[i]dp[i] 之前，我们已经计算出 dp[0…i−1] 的值，则状态转移方程为：
     * <p>
     * dp[i] = max(dp[j]) + 1,其中  0 <= j < i 且num[j]<num[i]
     * dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
     * <p>
     * 即考虑往 dp[0…i−1] 中最长的上升子序列后面再加一个 nums[i]。由于 dp[j]代表 nums[0…j] 中以 nums[j] 结尾的最长上升子序列，
     * 所以如果能从 dp[j] 这个状态转移过来，那么 nums[i] 必然要大于 nums[j]，才能将 nums[i] 放在 nums[j] 后面以形成更长的上升子序列。
     * <p>
     * 最后，整个数组的最长上升子序列即所有 dp[i]dp[i] 中的最大值。
     * <p>
     * LIS length=max(dp[i]),其中0≤i<n
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int max_dp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max_dp = Math.max(max_dp, dp[j]);
                }
            }
            dp[i] = max_dp + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
    //贪心 + 二分查找

}
