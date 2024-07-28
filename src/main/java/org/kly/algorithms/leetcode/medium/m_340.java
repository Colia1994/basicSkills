package org.kly.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author konglingyao
 * @date 2024/7/28
 */
public class m_340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            int cnt = map.getOrDefault(c, 0);
            map.put(c, cnt + 1);

            //判断当前是否超过最大限制
            if (map.size() <= k) {
                max = Math.max(max, right - left);
            }

            while (map.size() > k) {
                //超过后优化窗口
                char l = s.charAt(left);
                int cnt2 = map.getOrDefault(l, 0);
                if (cnt2 == 1) {
                    map.remove(l);
                } else {
                    map.put(l, cnt2 - 1);
                }
                left++;
            }
        }
        return max;
    }
}
