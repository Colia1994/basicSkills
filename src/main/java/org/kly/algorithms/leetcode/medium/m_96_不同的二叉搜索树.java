package org.kly.algorithms.leetcode.medium;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/5/21 8:46 下午
 */
public class m_96_不同的二叉搜索树 {

    /**
     * 任意一个节点作为根节点 左边和右边的组合想乘
     * dp dp[i] = dp[j-1]* d[i-j]
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //1 的树只有一个
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * 卡塔兰数
     * f(n+1) = f(n) * 2(2n+1)/(n+2)
     * f(0) = 1;
     */
    public int numTrees1(int n) {
        long c = 1;
        for (int i = 1; i <= n; i++) {
            c = c * 2 * (2 * i - 1) / (i + 1);
        }
        return (int)c;

    }


}
