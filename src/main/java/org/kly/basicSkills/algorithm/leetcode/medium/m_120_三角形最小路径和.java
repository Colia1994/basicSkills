package org.kly.basicSkills.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 *  
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 0 0 -> 1,0 ->
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author konglingyao
 * @Date 2020/7/14
 */
public class m_120_三角形最小路径和 {

    //dp[i][j] = min(dp[i-1][j], dp[i-1][j-1]) + v[i][j]
    public static int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        int m = triangle.size();
        int n_max = triangle.get(m - 1).size();
        //定义dp数组 注意大小
        int[][] dp = new int[m][n_max];
        //base case 处理
        dp[0][0] = triangle.get(0).get(0);

        //每一次到达可能的最后一层 维护答案
        if (0 == m - 1) {
            res = Math.min(dp[0][0], res);
        }
        for (int i = 1; i < m; i++) {
            int n_cell = triangle.get(i).size();
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][n_cell - 1] = dp[i - 1][n_cell - 2] + triangle.get(i).get(n_cell-1);
            //每一次到达可能的最后一层 维护答案
            if (i == m - 1) {
                res = Math.min(dp[i][0], res);
                res = Math.min(dp[i][n_cell-1], res);
            }
        }
        //开始dp dp[i][j] = min(dp[i-1][j], dp[i-1][j-1]) + v[i][j]
        for (int i = 2; i < m; i++) {
            int n_cell = triangle.get(i).size();
            for (int j = 1; j < n_cell-1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                if (i == m - 1) {
                    res = Math.min(dp[i][j], res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        test.add(new ArrayList<>(l1));
        l1.clear();
        l1.add(3);
        l1.add(4);
        test.add(new ArrayList<>(l1));
        l1.clear();
        l1.add(6);
        l1.add(5);
        l1.add(7);
        test.add(new ArrayList<>(l1));
        l1.clear();
        l1.add(4);
        l1.add(1);
        l1.add(8);
        l1.add(3);
        test.add(new ArrayList<>(l1));
        minimumTotal(test);
    }
}
