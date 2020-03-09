package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *

 * @Author Colia
 * @Date 2020/3/9.
 */
public class m_11_盛最多水的容器 {

    /**
     * 暴力破解

     */
    public int maxArea1(int[] height) {
        int length = height.length;

        int min = height[0] > height[length - 1] ? height[length - 1] : height[0];

        int maxArea = min * (length - 1);

        for (int i = 0; i < length; i++) {
            if(height[i] == 0){
                continue;
            }
            int start = maxArea / height[i];
            for (int j = i + start +1; j < length; j++) {
                int minin = height[i] > height[j] ? height[j] : height[i];
                int nowMax = minin * (j - i);
                maxArea = maxArea > nowMax ? maxArea : nowMax;

            }
        }

        return maxArea;

    }

    /**
     * 双指针

     */
    private static int maxArea(int[] height) {
        int length = height.length;


        int maxArea = 0;
        int minZj = 0;
        int maxZj = length - 1;
        while (maxZj >minZj){
            int low = Math.min(height[maxZj], height[minZj]);
            int now = (maxZj -minZj) * low ;
            maxArea = maxArea > now ?  maxArea : now;
            if(low == height[maxZj]){
                maxZj--;
            } else {
                minZj ++;
            }
        }

        return maxArea;

    }


    public static void main(String[] args) {

        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        maxArea(height);
    }
}
