package org.kly.basicSkills.algorithm.leetcode.hard;

/**
 * 偶数 个人站成一个圆，总人数为 num_people 。每个人与除自己外的一个人握手，所以总共会有 num_people / 2 次握手。
 * <p>
 * 将握手的人之间连线，请你返回连线不会相交的握手方案数。
 * <p>
 * 由于结果可能会很大，请你返回答案 模 10^9+7 后的结果。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/handshakes-that-dont-cross
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/5
 */
public class h_1259_不相交的握手 {
    //dp
    //找到一条线 将图分成两个部分 两个部分的沉积为新的部分按此线分割的次数 求各种分割下的和
    public int numberOfWays(int num_people) {
        int mod = 1000000007;

        int[] dp = new int[num_people + 1];
        dp[0] = 1;
        //人数为偶数
        for (int i = 2; i <= num_people; i += 2) {
            //需要分割为偶数部分 1和第j个人握手 分割为 1-j j-i两部分
            for (int j = 2; j <= i; j += 2) {
                dp[i] = (int)(dp[i] + (long) dp[j - 2] * dp[i - j] % mod) % mod;
            }
        }

        return dp[num_people];
    }
}
