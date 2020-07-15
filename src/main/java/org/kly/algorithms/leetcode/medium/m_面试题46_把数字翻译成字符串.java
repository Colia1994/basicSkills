package org.kly.algorithms.leetcode.medium;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 *
 * @Author konglingyao
 * @Date 2020/6/9 10:53 上午
 */
public class m_面试题46_把数字翻译成字符串 {

    public int translateNum(int num) {
        String src = String.valueOf(num);

        int[] dp = new int[src.length()];
        dp[0] = 1;
        for (int i = 1; i < src.length(); i++) {
            dp[i] = dp[i - 1];
            int pre = Integer.parseInt(src.substring(i - 1, i + 1));
            if (pre >= 10 && pre <= 25) {
                if(i>=2) {
                    dp[i] += dp[i - 2];
                } else {
                    dp[i] += 1;
                }
            }
        }

        return dp[src.length() - 1];

//        int p = 0, q = 0, r = 1;
//        for (int i = 0; i < src.length(); ++i) {
//            p = q;
//            q = r;
//            r = 0;
//            r += q;
//            if (i == 0) {
//                continue;
//            }
//            String pre = src.substring(i - 1, i + 1);
//            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
//                r += p;
//            }
//        }
//        return r;

    }

    public static void main(String[] args) {
        m_面试题46_把数字翻译成字符串 m = new m_面试题46_把数字翻译成字符串();
        m.translateNum(25);
    }
}
