package org.kly.algorithms.leetcode.medium;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @Author konglingyao
 * @Date 2020/7/3
 */
public class m_31 {

    //1 从后向前找到存在的第一个 i 使得 nums[i-1] < nums[i]
    //2 如果存在i-end 则 必降序 寻找i-end中存在的第一个k 使得 num[i-1] < num[k] swap
    //3 此时i-end还是降序
    //4 反转i-end部分 使之升序
    //5 若1招不到存在的i 则直接 按4 反转整个数组 并返回
    public void nextPermutation(int[] nums) {
        //1
        int i = 0, k = 0;
        int end = nums.length - 1;

        for (int j = end; j > 0; j--) {
            if (nums[j] > nums[j - 1]) {
                i = j;
                break;
            }
        }
        if (i > 0) {
            //2
            for (int j = end; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    k = j;
                    break;
                }
            }

            //3
            int ls = nums[k];
            nums[k] = nums[i - 1];
            nums[i - 1] = ls;
        }
        //4
        while (i < end) {
            int ls1 = nums[end];
            nums[end] = nums[i];
            nums[i] = ls1;
            i++;
            end--;
        }
    }


}
