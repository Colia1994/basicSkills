package org.kly.basicSkills.algorithm.leetcode.easy;

/**
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 *
 * 示例 1:
 *
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明:  n 的范围为 [1, 10,000]。
 *
 * @Author Colia
 * @Date 2020/3/10.
 */
public class e_665_非递减数列 {

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                j = i;
            }
        }
        //如果 p = 0，那么我们可以通过设置 A[p] = A[p+1] 使数组变成非递减数列。
        //如果 p = len(A) - 2，则可以通过设置 A[p+1] = A[p] 使数组变成非递减数列。
        //否则，A[p-1], A[p], A[p+1], A[p+2] 都存在，并且：
        //如果可能的话，我们可以将 A[p] 更改为 A[p-1] 和 A[p+1] 之间。
        //如果可能的话，我们可以将 A[p+1] 更改为 A[p] 和 A[p+2] 之间的值。
        return count != 1 ? count <= 0 : (j == 0 || j == (nums.length - 2)) || (nums[j - 1] < nums[j + 1] || nums[j] < nums[j + 2]);

    }
}
