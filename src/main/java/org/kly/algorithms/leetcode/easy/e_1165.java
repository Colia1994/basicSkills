package org.kly.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class e_1165 {

    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }
        int step = map.get(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            step += Math.abs(map.get(word.charAt(i)) - map.get(word.charAt(i - 1)));
        }
        return step;
    }
}
