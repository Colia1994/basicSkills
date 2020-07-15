package org.kly.algorithms.leetcode.easy;

/**
 * 1071. 字符串的最大公因子
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * <p>
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * 示例 1：
 * <p>
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *
 * @Author Colia
 * @Date 2020/1/7 13:28
 */
public class e_1071_字符串的最大公因子 {
    public String gcdOfStrings(String str1, String str2) {


        if ((str1 + str2).equals(str2 + str1)) {
            int gcd;
            int alenth = str1.length();
            int blenth = str2.length();
            while (blenth > 0) {
                gcd = alenth % blenth;
                alenth = blenth;
                blenth = gcd;
            }


            return str1.substring(0, alenth);
        } else {
            return "";
        }
    }


}
