package org.kly.algorithms.leetcode.easy;

/**
 * @author konglingyao
 * @date 2024/7/23
 */
public class e_28 {

    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length() + 1];
        haystack = " " + haystack;
        needle = " " + needle;
        next[0] = 0;
        next[1] = 0;
        for (int i = 2; i < needle.length(); i++) {
            int j = next[i - 1];
            while (j > 0 && needle.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (needle.charAt(i) == needle.charAt(j + 1)) {
                next[i] = j + 1;
            } else {
                next[i] = j;
            }
        }
        for (int i = 1, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            // 整一段匹配成功，直接返回下标
            if (j == needle.length()-1) return i - needle.length() + 1;

        }
        return -1;
    }


    public int strStr1(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }

        return -1;
    }

    public static void main(String[] args) {
        e_28 obj = new e_28();
        System.out.println(obj.strStr("jaississip", "issip"));
    }
}
