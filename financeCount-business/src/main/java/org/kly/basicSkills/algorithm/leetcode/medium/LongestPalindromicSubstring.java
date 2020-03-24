package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author colia
 * @date 2018/12/17 23:35
 */
public class LongestPalindromicSubstring {

    /**
     * 第一次解答
     */
    public String longestPalindrome(String s) {
        String resultString = "";
        if (s.length() == 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                int length = validateH(s.substring(i, j));
                if (length > resultString.length()) {
                    resultString = s.substring(i, j);
                }
            }
        }
        return resultString;
    }

    /**
     * 判断是否是回文串
     */
    private int validateH(String chars) {
        int i = 0;
        int l = chars.length();
        while (i <= l - i - 1) {
            if (chars.charAt(i) != chars.charAt(l - 1 - i)) {
                return 0;
            }
            i++;
        }
        return chars.length();
    }

    /**
     * 中心扩展
     */
    public String longestPalindromeZX(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


}
