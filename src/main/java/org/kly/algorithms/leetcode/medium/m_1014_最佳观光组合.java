package org.kly.algorithms.leetcode.medium;

/**
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 *
 * @Author konglingyao
 * @Date 2020/6/17
 */
public class m_1014_最佳观光组合 {

    public int maxScoreSightseeingPair(int[] A) {
        //ai +i
        int pre = 0;
        //ai + i + aj -j
        int current = 0;

        for (int i = 1; i < A.length; i++) {
            pre = Math.max(pre, A[i - 1] + i - 1);
            current = Math.max(current, pre + A[i] - i);
        }
        return current;
    }
}
