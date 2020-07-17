package org.kly.algorithms.leetcode.easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/17
 */
public class e_35_搜索插入位置 {

    //二分
    public int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (nums[mid] < target) {
                //目标在右
                s = mid + 1;
            } else if (nums[mid] > target) {
                //目标在左
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return nums[s] >= target ? s : s + 1;

    }
}
