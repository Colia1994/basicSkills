package org.kly.algorithms.leetcode.hard;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/5
 */
public class h_135_分发糖果 {

    /**
     * 双向扫描 单数组
     */
    public int candy(int[] ratings) {
        int[] dpLeft = new int[ratings.length];
        Arrays.fill(dpLeft, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dpLeft[i] = dpLeft[i - 1] + 1;
            }
        }
        int res = dpLeft[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dpLeft[i] = Math.max(dpLeft[i + 1] + 1, dpLeft[i]);
            }
            res += dpLeft[i];
        }
        return res;

    }

    /**
     * 双向扫描 双数组
     */
    public int candy1(int[] ratings) {
        int[] dpLeft = new int[ratings.length];
        int[] dpRight = new int[ratings.length];
        Arrays.fill(dpLeft, 1);
        Arrays.fill(dpRight, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dpLeft[i] = dpLeft[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dpRight[i] = dpRight[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < dpLeft.length; i++) {
            res += Math.max(dpLeft[i], dpRight[i]);

        }
        return res;

    }
}
