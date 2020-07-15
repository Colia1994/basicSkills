package org.kly.algorithms.leetcode.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/6/15
 */
public class e_14_最长的公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        String str1 = "";
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
            if (minLength == str.length()) {
                str1 = str;
            }
        }
        for (String str : strs) {
            int i = 0;
            while (i < str1.length()) {
                if (str1.charAt(i) == str.charAt(i)) {
                    i++;
                } else {
                    break;
                }
            }
            str1 = str1.substring(0,i);
        }
        return str1;


    }


    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        e_14_最长的公共前缀 e = new e_14_最长的公共前缀();
        e.longestCommonPrefix(strs);
    }
}
