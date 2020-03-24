package org.kly.basicSkills.algorithm.leetcode.easy;

/**
 * @author colia
 * @date 2020/1/10 12:05
 */
public class EXCEL26进制问题 {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int charNum = (int) s.charAt(i) - 64;
            result = result * 26 + charNum;
        }
        return result;

    }

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            int x = n % 26;
            x = x == 0 ? 26 : x;
            result.insert(0, (char) (x + 64));
            n = (n - x) / 26;
        }

        return result.toString();
    }
}
