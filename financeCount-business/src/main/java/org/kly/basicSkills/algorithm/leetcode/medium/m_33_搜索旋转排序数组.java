package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/3
 */
public class m_33_搜索旋转排序数组 {

    //二分查找变种
    public int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        int s = 0;
        int e = nums.length - 1;
        int mid;
        while (s < e) {
            mid = (s + e) / 2;
            if (nums[mid] >= nums[s]) {
                //mid左侧一定有序
                if (nums[mid] >= target && nums[s] <= target) {
                    e = mid;
                } else {
                    if (mid == s) {
                        return nums[e] == target ? e : -1;
                    }
                    s = mid;
                }
            } else {
                //mid右侧一定有序
                if (nums[mid] <= target && nums[e] >= target) {
                    s = mid;
                } else {
                    e = mid;
                }
            }
        }

        return nums[s] == target ? s : -1;
    }

    public static void main(String[] args) {
        m_33_搜索旋转排序数组 m = new m_33_搜索旋转排序数组();
        m.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
    }
}
