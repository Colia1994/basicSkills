package org.kly.algorithms.leetcode.easy;

/**
 * @Author konglingyao
 * @Date 2023/5/9
 */
public class e_2437 {

    public int countTime(String time) {
        if (time.length() != 5) {
            return -1;
        }

        if (time.charAt(2) != ':') {
            return -1;
        }
        int result = 1;
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            result *= 24;
        } else if ((time.charAt(0) == '0' || time.charAt(0) == '1') && time.charAt(1) == '?') {
            result *= 10;
        } else if (time.charAt(0) == '2' && time.charAt(1) == '?') {
            result *= 4;
        } else if (time.charAt(0) == '?' && time.charAt(1) - '0' > 3) {
            result *= 2;
        } else if (time.charAt(0) == '?' && time.charAt(1) - '0' < 4) {
            result *= 3;
        }

        if (time.charAt(3) == '?' && time.charAt(4) == '?') {
            result *= 60;
        } else if (time.charAt(3) == '?') {
            result *= 6;
        } else if (time.charAt(4) == '?') {
            result *= 10;
        }

        return result;
    }
}
