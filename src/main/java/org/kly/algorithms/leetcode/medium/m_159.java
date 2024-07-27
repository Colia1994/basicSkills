package org.kly.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class m_159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int x = 0, y = 0;
        int max = 0;
        while (y < s.length()) {
            map.put(s.charAt(y), map.getOrDefault(s.charAt(y), 0) + 1);

            while(map.keySet().size() > 2){
                // 移动x
                int count = map.get(s.charAt(x));
                if (count == 1) {
                    map.remove(s.charAt(x));
                } else {
                    map.put(s.charAt(x), count - 1);
                }
                x++;
            }
            max = Math.max(max,y-x+1);
            // 移动
            y++;

        }

        return max;
    }
}
