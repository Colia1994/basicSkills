package org.kly.algorithms.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author konglingyao
 * @date 2024/7/26
 */
public class m_1100 {

    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) return 0;

        //存储k个不重复
        Set<Character> set = new HashSet<>();
        int count = 0;
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (end - start == k) {
                count++;
            }
            if (set.contains(s.charAt(end))) {
                while (start < end && s.charAt(start) != s.charAt(end)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.remove(s.charAt(start));
                start++;
                set.add(s.charAt(end));
                end++;
            } else {
                set.add(s.charAt(end));
                end++;
                if (end - start > k) {
                    set.remove(s.charAt(start));
                    start++;
                }
            }



        }

        return count;
    }

    public static void main(String[] args) {
        m_1100 m = new m_1100();
        m.numKLenSubstrNoRepeats("gdggdbjchgadcfddfahbdebjbagaicgeahehjhdfghadbcbbfhgefcihbcbjjibjdhfhbdijehhiabad", 5);
    }
}
