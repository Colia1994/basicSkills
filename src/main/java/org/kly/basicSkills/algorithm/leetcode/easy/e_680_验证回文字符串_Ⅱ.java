package org.kly.basicSkills.algorithm.leetcode.easy;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/3/18.
 */
public class e_680_验证回文字符串_Ⅱ {

    int del = 0;  //记录删除的字符次数

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                //不相等的话，若没有删除字符，则删除左边或右边的字符再判断；若删除过一次，则不是回文串
                if (del == 0) {
                    del++;
                    return validPalindrome(s.substring(i, j)) || validPalindrome(s.substring(i + 1, j + 1));
                }
                return false;
            }
        }
        return true;
    }

}
