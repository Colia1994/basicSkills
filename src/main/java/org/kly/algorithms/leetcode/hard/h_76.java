package org.kly.algorithms.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class h_76 {

    /**
     * s = "ADOBECODEBANC", t = "ABC"
     */
    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int valid = 0;
        String res = "";
        while (right < s.length()) {

            char c = s.charAt(right);
            if (map.containsKey(c)) {
                int winCnt = window.getOrDefault(c, 0) + 1;
                window.put(c, window.getOrDefault(c, 0) + 1);
                int mapCnt = map.getOrDefault(c, 0);
                if (winCnt == mapCnt) {
                    valid++;
                }
            }

            right++;


            while (valid == map.size()) {
                //窗口构造完成，记录最小值
                String nRes = s.substring(left, right);
                if (res.isEmpty()) {
                    res = nRes;
                } else {
                    res = res.length() < nRes.length() ? res : nRes;
                }

                //更新left
                char c1 = s.charAt(left);
                int win = window.getOrDefault(c1, 0);
                int mapc = map.getOrDefault(c1, 0);
                if (map.containsKey(c1)) {
                    if (win == mapc) {
                        //要删除c1 则会打破valid 需要减少一个
                        valid--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
                left++;

            }

        }

        return res;
    }
}
