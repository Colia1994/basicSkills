package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。z`
 *
 * @Author konglingyao
 * @Date 2020/6/29
 */
public class m_215_数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        int p = partition(nums, 0, nums.length - 1);
        while (p != k - 1) {
            if (p > k - 1) {
                p = partition(nums, 0, p - 1);
            } else {
                p = partition(nums, p + 1, nums.length - 1);
            }
        }
        return nums[k];

    }

    private int partition(int[] nums, int start, int end) {
        int p = nums[end];
        while (start < end) {

            while (start < end && nums[start] >= p) {
                start++;
            }
            swap(nums, start, end);
            while (start < end && nums[end] <= p) {
                end--;
            }
            swap(nums, start, end);
        }
        return start;
    }

    public void swap(int[] inputArray, int i, int j) {
        int a = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = a;
    }

    public static void main(String[] args) {
        m_215_数组中的第K个最大元素 m = new m_215_数组中的第K个最大元素();
        int[] nums = new int[]{3, 2, 5, 70, 20, 4, -10, -2, 6};
        m.findKthLargest(nums, 4);

    }
}
