package org.kly.basicSkills.algorithm.leetcode.hard;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/8
 */
public class h_41_缺失的第一个正数 {

    public int firstMissingPositive(int[] nums) {
        //nums 用存在的数1-n部分填充
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = nums[i];

            while (j >= 1 && j <= n && nums[j - 1] != j) {
                int i1 = nums[j - 1];
                nums[j - 1] = j;
                j = i1;
            }


        }
        int res = n + 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res = i + 1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        h_41_缺失的第一个正数 h = new h_41_缺失的第一个正数();
        h.firstMissingPositive(new int[]{0, 1, 2});
    }

    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }


}
