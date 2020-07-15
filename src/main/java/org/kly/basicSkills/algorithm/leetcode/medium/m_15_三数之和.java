package org.kly.basicSkills.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @Author konglingyao
 * @Date 2020/6/12
 */
public class m_15_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int count = nums[i] + nums[l] + nums[r];
                if (count == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < nums.length - 1 && nums[l] == nums[++l]) {
                    }
                    while (r > i && nums[r] == nums[--r]) {
                    }
                } else if (count > 0) {
                    while (r > i && nums[r] == nums[--r]) {
                    }
                } else {
                    while (l < nums.length - 1 && nums[l] == nums[++l]) {
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        m_15_三数之和 m = new m_15_三数之和();
        m.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
    }

}
