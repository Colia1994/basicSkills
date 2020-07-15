package org.kly.algorithms.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @Author konglingyao
 * @Date 2020/7/13
 */
public class e_349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resMap = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (Integer i : nums1) {
            resMap.add(i);
        }
        for (Integer j : nums2) {
            if (resMap.contains(j)) {
                res.add(j);
            }
        }
        int[] res1 = new int[res.size()];
        int i1 = 0;
        for (Integer i : res) {
            res1[i1] = i;
            i1++;
        }
        return res1;
    }
}
