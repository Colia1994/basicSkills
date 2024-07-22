package org.kly.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class e_205 {


    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (mapS.get(s.charAt(i)) == null  || mapS.get(s.charAt(i)) == t.charAt(i)) {
                mapS.put(s.charAt(i), t.charAt(i));
            } else {
                return false;
            }
            if (mapT.get(t.charAt(i)) == null || mapT.get(t.charAt(i)) == s.charAt(i)) {
                mapT.put(t.charAt(i), s.charAt(i));
            } else {
                return false;
            }

        }
        return true;
    }
}
