package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * @Author konglingyao
 * @Date 2020/6/4 5:54 下午
 */
public class m_238_除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int count = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            count *= nums[i + 1];
            result[i] *= count;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] test01 = new int[]{1, 2, 3, 4};
        m_238_除自身以外数组的乘积 test = new m_238_除自身以外数组的乘积();
        int[] test02 = test.productExceptSelf(test01);
        for (int i : test02) {
            System.out.println(i);
        }
    }
}
