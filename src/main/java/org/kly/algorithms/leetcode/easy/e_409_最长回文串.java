package org.kly.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * @Author Colia
 * @Date 2020/3/19.
 */
public class e_409_最长回文串 {

    public int longestPalindrome(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character i : s.toCharArray()) {
            charMap.put(i, charMap.getOrDefault(i, 0) + 1);
        }
        int max_length = 0;
        for (Integer integer : charMap.values()) {
            if (integer % 2 > 0) {
                //奇数 取偶数部分
                max_length += integer - 1;
            } else {
                //偶数 累加
                max_length += integer;
            }
        }
        if (max_length < s.length()) {
            max_length++;
        }
        return max_length;
    }
}
