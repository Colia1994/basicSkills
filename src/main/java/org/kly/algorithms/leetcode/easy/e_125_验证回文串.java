package org.kly.algorithms.leetcode.easy;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/6/19
 */
public class e_125_验证回文串 {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9a-zA-Z]+","");
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        e_125_验证回文串 e = new e_125_验证回文串();
        System.out.println(e.isPalindrome(s));
    }
}
