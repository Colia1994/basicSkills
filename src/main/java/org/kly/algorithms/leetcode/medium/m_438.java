package org.kly.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class m_438 {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int n = p.length();
        int nCount = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {

            char c = s.charAt(right);
            int cnt = map.getOrDefault(c, 0);
            if (cnt > 0) {
                right++;
                nCount++;
                map.put(c, cnt - 1);
                if (nCount == n) {
                    res.add(left);
                }
            } else {
                //还原 left
                if (nCount > 0) {
                    //有累计-- 需要还原
                    char l = s.charAt(left);
                    map.put(l, map.getOrDefault(l, 0) + 1);
                    nCount--;
                    left++;
                } else {
                    // 本次移动是错误的，直接更新left
                    left++;
                    right++;
                }
            }
        }
        return res;


    }
}
