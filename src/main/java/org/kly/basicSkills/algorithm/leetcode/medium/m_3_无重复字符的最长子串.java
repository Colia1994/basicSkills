package org.kly.basicSkills.algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author colia
 * @date 2018/12/16 0:42
 */
public class m_3_无重复字符的最长子串 {


    /**
     * map集合法
     */
    public int lengthOfLongestSubstringMine(String s) {
        int resultNum = 0;
        int l = s.length();
        Map<Character, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < l; i++) {
            if (integerMap.containsKey(s.charAt(i))) {
                //重复后 移动指针
                i = integerMap.get(s.charAt(i));
                integerMap.clear();
            } else {
                integerMap.put(s.charAt(i), i);
            }
            //更新计数
            resultNum = Math.max(integerMap.size(), resultNum);
        }

        return resultNum;
    }


    /**
     * map集合法 优化  abcabcbb
     */
    public static int lengthOfLongestSubstringMineNext(String s) {
        int resultNum = 0;
        int l = s.length();
        Map<Character, Integer> integerMap = new HashMap<>();
        for (int i = 0, j = 0; i < l; i++) {
            if (integerMap.containsKey(s.charAt(i))) {
                //重复后 移动指针
                j = Math.max(integerMap.get(s.charAt(i)), j);
            }
            //+1 是为了初始值不被跳过
            integerMap.put(s.charAt(i), i + 1);

            //更新计数
            resultNum = Math.max(i - j + 1, resultNum);
        }

        return resultNum;
    }

    /**
     * Brute Force
     */
    public int lengthOfLongestSubstringBruteForce(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /**
     * set滑块
     */
    public int lengthOfLongestSubstringSet(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * set滑块 Map版本
     */
    public int lengthOfLongestSubstringMap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * 20200107
     */
    public int lengthOfLongestSubstring(String s) {
        int resultNum = 0;
        int l = s.length();
        Map<Character, Integer> integerMap = new HashMap<>();
        for (int i = 0, j = 0; i < l; i++) {
            if (integerMap.containsKey(s.charAt(i))) {
                //重复后 移动指针
                j = integerMap.get(s.charAt(i)) >= j ? integerMap.get(s.charAt(i)) + 1 : j;
            }
            integerMap.put(s.charAt(i), i);

            //更新计数
            resultNum = Math.max(i - j + 1, resultNum);
        }

        return resultNum;
    }
}
