package org.kly.algorithms.leetcode.easy;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/3/30.
 */
public class e_面试题62_圆圈中最后剩下的数字 {

    public int lastRemaining1(int n, int m) {
        //控制递归出口
        if (n == 1) {
            return 0;
        }
        //执行递归 计算f(n-1,m)的值
        int x = lastRemaining1(n - 1, m);
        //
        return (m + x) % n;
    }


    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }

}
