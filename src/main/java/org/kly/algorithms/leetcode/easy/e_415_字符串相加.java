package org.kly.algorithms.leetcode.easy;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/8/3
 */
public class e_415_字符串相加 {

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1;
        int up = 0;
        while (i >= 0 && j >= 0) {
            int m = (int) num1.charAt(i) + (int) num2.charAt(j) + up -96;
            res.append(m % 10);
            if (m / 10 >= 1) {
                up = 1;
            } else {
                up = 0;
            }
            i--;
            j--;
        }
        while (i >= 0) {
            int m = num1.charAt(i) + up-48;
            res.append(m % 10);
            if (m / 10 >= 1) {
                up = 1;
            } else {
                up = 0;
            }
            i--;
        }
        while (j >= 0) {
            int m = num2.charAt(j) + up-48;
            res.append(m % 10);
            if (m / 10 >= 1) {
                up = 1;
            } else {
                up = 0;
            }
            j--;
        }
        if (up > 0) {
            res.append(up);
        }
        return res.reverse().toString();
    }


    public static void main(String[] args){
        e_415_字符串相加 e = new e_415_字符串相加();
        e.addStrings("0","0");
        System.out.println(Integer.parseInt("0") + (int) "0".charAt(0));
        System.out.println((int) "0".charAt(0));
    }
}
