package org.kly.algorithms.leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/3/30.
 */
public class h_32_最长有效括号 {

    //动态规划 dp数组记录i位置结尾的最长有效括号
    //推导 当i为左括号（ 则为0
    //当i为 右括号） 且 i-1为左括号 （ 直接 dp[i] = dp[i-2] +2
    //当i为右括号） 且i-1 为左括号） 找到dp[i-1] 长度前一位 i-dp[i-1] -1 确认是不是左括号
    //是当话 直接 dp[i] = dp[i-1] + dp[i-dp[i-1]-1-1] +2
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - 2 - dp[i - 1]) > 0 ? dp[i - 2 - dp[i - 1]] : 0) + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //栈
    public int longestValidParentheses1(String s) {
        Deque<Integer> stack = new LinkedList<>();
        return 0;
    }

    //双向扫描
    public int longestValidParentheses2(String s) {
        int left = 0, right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, right * 2);
            } else if (left < right) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                max = Math.max(max, right * 2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }
}
