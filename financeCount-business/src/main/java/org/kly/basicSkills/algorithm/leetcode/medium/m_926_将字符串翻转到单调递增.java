package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 926. FlipStringtoMonotoneIncreasing
 * A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), followed by some number of '1's (also possibly 0.)
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
 * Return the minimum number of flips to make S monotone increasing.
 * <p>
 * Example 1:
 * Input: "00110"
 * Output: 1
 * Explanation: We flip the last digit to get 00111.
 * Example 2:
 * Input: "010110"
 * Output: 2
 * Explanation: We flip to get 011111, or alternatively 000111.
 * Example 3:
 * Input: "00011000"
 * Output: 2
 * Explanation: We flip to get 00000000.
 *
 * @author colia
 * @date 2018/12/13 0:14
 */
public class m_926_将字符串翻转到单调递增 {


    public int minFlipsMonoIncr(String S) {
        char[] nums = S.toCharArray();
        int one = 0;//尾数为1最优解
        int zero = 0;//尾数为0最优解

        for (char num : nums) {
            if (num == '0') {
                //尾数为1最优解 =全局最优解+1
                one = Math.min(one, zero) + 1;
                //尾数为0最优解不变
            } else {
                //尾数为1最优解 =全局最优解
                one = Math.min(one, zero);
                //尾数为0最优解  +1
                zero += 1;
            }

        }
        return Math.min(one, zero);
    }

    public int minFlipsMonoIncr1(String S) {
        int N = S.length();
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            //计算第从左向右 1的数目
            P[i + 1] = P[i] + (S.charAt(i) == '1' ? 1 : 0);
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= N; ++j) {
            //假设第j位是分割左右 01的界限 0~j都是0 j到n都是1
            //0~j的1需要翻转 P[j]
            //j到n 的0 需要翻转 P[N]-P[j]是 j到n的1出现的次数
            ans = Math.min(ans, P[j] + N - j - (P[N] - P[j]));
        }

        return ans;
    }

}
