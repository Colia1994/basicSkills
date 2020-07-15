package org.kly.algorithms.leetcode.easy;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 * <p>
 * 字符串长度在[0, 50000]范围内。
 *
 * @Author Colia
 * @Date 2020/3/16.
 */
public class e_面试题_01_06_字符串压缩 {
    public String compressString(String S) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        int index_fast = 1;
        while (index_fast <= S.length()) {
            if (index_fast < S.length() && S.charAt(index) == S.charAt(index_fast)) {
                index_fast++;
            } else {
                result.append(S.charAt(index)).append(index_fast - index);
                index = index_fast;
                index_fast++;

            }
        }
        return result.length() < S.length() ? result.toString() : S;

    }
}
