package org.kly.basicSkills.algorithm.leetcode.hard;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @Author Colia
 * @Date 2020/4/4.
 */
public class h_42_接雨水 {

//    public int trap(int[] height) {
//        int sum = 0;
//        int[] max_left = new int[height.length];
//        int[] max_right = new int[height.length];
//
//        for (int i = 1; i < height.length - 1; i++) {
//            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
//        }
//        for (int i = height.length - 2; i >= 0; i--) {
//            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
//        }
//        for (int i = 1; i < height.length - 1; i++) {
//            int min = Math.min(max_left[i], max_right[i]);
//            if (min > height[i]) {
//                sum = sum + (min - height[i]);
//            }
//        }
//        return sum;
//    }

    public int trap(int[] height) {
        int sum = 0;
        //dp 任意元素向左最大
        int[] max_left = new int[height.length];
        //dp 任意元素向右最大
        int[] max_right = new int[height.length];

        max_left[0] = height[0];
        max_right[0] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i > 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int minLength = Math.min(max_left[i], max_right[i]);
            if (minLength - height[i] > 0) {
                sum += minLength - height[i];
            }
        }
        return sum;
    }

}
