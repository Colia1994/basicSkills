package org.kly.algorithms.leetcode.easy;

/**
 * @author konglingyao
 * @date 2024/7/22
 */
public class e_58 {

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;

        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (length != 0) {
                    return length;
                }
            } else {
                length++;
            }

        }
        return length;
    }
}
