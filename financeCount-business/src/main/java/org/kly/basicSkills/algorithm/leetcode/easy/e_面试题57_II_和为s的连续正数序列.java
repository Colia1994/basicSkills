package org.kly.basicSkills.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/3/17.
 */
public class e_面试题57_II_和为s的连续正数序列 {


    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int r = 1, l = 2;
        while (r <= target / 2) {
            int sum = (l - r + 1) * (l + r) / 2;
            if (target == sum) {
                int[] r_in = new int[l - r + 1];
                int init = r;
                while (init <= l) {
                    r_in[init - r] = init;
                    init++;
                }
                res.add(r_in);
                r++;

            } else if (target > sum) {
                l++;
            } else {
                r++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

}
