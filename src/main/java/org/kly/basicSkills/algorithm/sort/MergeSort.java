package org.kly.basicSkills.algorithm.sort;

/**
 * 归并排序
 * 时间复杂度 O(n * log n)
 * 空间复杂度 O(n)
 * 稳定排序
 *
 * @Author konglingyao
 * @Date 2018/12/28
 */
public class MergeSort {

    //归并
    public int[] sortArrayGB(int[] nums) {
        int[] copy = new int[nums.length];
        guiBing(nums, copy, 0, nums.length - 1);
        return copy;
    }

    private void guiBing(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (end + start) / 2;
        guiBing(nums, copy, start, mid);
        guiBing(nums, copy, mid + 1, end);
        int i = mid;
        int j = end;
        int k = end;
        while (i >= start && j >= mid + 1) {
            if (nums[i] > nums[j]) {
                copy[k--] = nums[i--];
            } else {
                copy[k--] = nums[j--];
            }
        }
        while (i >= start) {
            copy[k--] = nums[i--];
        }
        while (j >= mid + 1) {
            copy[k--] = nums[j--];
        }
        if (end + 1 - start >= 0) {
            System.arraycopy(copy, start, nums, start, end + 1 - start);
        }
    }
}
