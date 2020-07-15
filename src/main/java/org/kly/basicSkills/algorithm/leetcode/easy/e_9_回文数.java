package org.kly.basicSkills.algorithm.leetcode.easy;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @Author konglingyao
 * @Date 2020/5/25 5:24 下午
 */
public class e_9_回文数 {

    public static boolean isPalindrome(int x) {


        if (x < 0) {
            return false;
        }
        int org = x;
        int newPal = 0;
        while (x > 0) {
            newPal = newPal * 10 + x % 10;
            x = x / 10;
        }
        return newPal == org;
    }

    public static void main(String[] args) {
        System.out.println(e_9_回文数.isPalindrome(121));
    }
}
