package org.kly.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class e_242 {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            int cnt = map.getOrDefault(c, 0);
            if (cnt == 0) {
                return false;
            } else if (cnt == 1) {
                map.remove(c);
            } else {
                map.put(c, map.getOrDefault(c, 0) - 1);
            }
        }

        return map.isEmpty();
    }
}
