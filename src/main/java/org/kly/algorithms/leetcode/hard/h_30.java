package org.kly.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class h_30 {

    public List<Integer> findSubstring(String s, String[] words) {




        int n = words[0].length();
        int count = words.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();

            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            int nCount = 0;
            //滑动窗口，满足条件是nCount =  count
            int left = i;
            int right = i;
            while (right <= s.length()-n) {
                String code = s.substring(right, right + n);
                int cnt = map.getOrDefault(code, 0);
                if (cnt > 0) {
                    nCount++;
                    right += n;
                    map.put(code, cnt - 1);
                    if (nCount == count) {
                        res.add(left);
                    }
                } else {
                    //当前单词不满足 移动左指针 每次移动判断下 是否需要还原 map
                    if (nCount > 0) {
                        String preCode = s.substring(left, left + n);
                        map.put(preCode, map.getOrDefault(preCode, 0) + 1);
                        nCount--;
                        left += n;
                    } else {
                        right += n;
                        left += n;
                    }
                }

            }


        }

        return res;

    }
}
