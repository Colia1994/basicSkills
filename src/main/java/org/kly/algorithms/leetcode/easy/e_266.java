package org.kly.algorithms.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class e_266 {

    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if(set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.size() == 1 || set.isEmpty();
    }
}
