package org.kly.algorithms.leetcode.medium;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/22
 */
public class m_153_寻找旋转排序数组中的最小值 {

    //二分
    public int findMin(int[] nums) {

        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (nums[s] > nums[e]) {
                if (nums[s] < nums[mid]) {
                    s = mid + 1;
                } else if (nums[s] > nums[mid]) {
                    e = mid;
                } else {
                    s = e;
                    break;
                }
            } else {
                break;
            }
        }
        return Math.min(nums[0], nums[s]);
    }

    /**
     * 有重复
     * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
     */
    public int minArray(int[] numbers) {

        int s = 0;
        int e = numbers.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (numbers[s] > numbers[e]) {
                if (numbers[s] <= numbers[mid]) {
                    s = mid + 1;
                } else if (numbers[s] > numbers[mid]) {
                    e = mid;
                } else {
                    s = e;
                    break;
                }
            } else if(numbers[s] < numbers[e]){
                break;
            } else {
                e--;
            }
        }
        return Math.min(numbers[0], numbers[s]);
    }
}
