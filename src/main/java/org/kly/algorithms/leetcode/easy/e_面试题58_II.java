package org.kly.algorithms.leetcode.easy;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= k < s.length <= 10000
 *
 * @Author Colia
 * @Date 2020/3/10.
 */
public class e_面试题58_II {

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

}
