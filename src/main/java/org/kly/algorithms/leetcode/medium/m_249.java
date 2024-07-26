package org.kly.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author konglingyao
 * @date 2024/7/26
 */
public class m_249 {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strings) {
            String key = generateKey(str);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(str);
        }
        return new ArrayList<List<String>>(groups.values());
    }

    public String generateKey(String str) {
        StringBuffer sb = new StringBuffer();
        int length = str.length();
        for (int i = 1; i < length; i++) {
            int difference = str.charAt(i) - str.charAt(i - 1);
            if (difference < 0) {
                difference += 26;
            }
            sb.append((char) ('a' + difference));
        }
        return sb.toString();
    }
}
