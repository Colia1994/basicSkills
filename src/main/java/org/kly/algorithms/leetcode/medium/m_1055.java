package org.kly.algorithms.leetcode.medium;

public class m_1055 {

    public int shortestWay(String source, String target) {

        // 构造 source的dp数组 用于快速o1的定位下个字符

        int m = source.length();
        int[][] dp = new int[m + 1][26];

        // 构造边界值 不可达m
        for (int i = 0; i < 26; i++) {
            dp[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (source.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        // 循环target 如果扫描完毕 则计数+1 并清空find
        int find = 0;
        int count = 0;
        for (int i = 0; i < target.length(); i++) {

            if (dp[find][target.charAt(i) - 'a'] == m) {
                if(find == 0 ){
                    //当权不存在
                    return -1;
                }
                count++;
                find = 0;
                i--;
            } else {
                find = dp[find][target.charAt(i) - 'a'] + 1;
            }
        }

        return ++count;

    }
}
