package org.kly.algorithms.leetcode.medium;

/**
 * @author konglingyao
 * @date 2024/7/26
 */
public class m_186 {

    public void reverseWords(char[] s) {
        int n = s.length;
        int start = 0;
        int end = 0;

        while (start < n && end < n) {

            if (s[end] == ' ') {
                //遇到空格，需要翻转
                reverse(s, start, end - 1);
                start = end + 1;
                end = end + 2;
            } else if (end == n - 1) {
                //走到最后，需要翻转
                reverse(s, start, end);
                start = end + 1;
                end = end + 2;
            } else {
                end++;
            }
        }
        reverse(s, 0, n - 1);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
