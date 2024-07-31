package org.kly.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class m_131 {
    boolean[][] dp;
    int n;
    List<List<String>> ans = new ArrayList<>();
    List<String> rst = new ArrayList<>();

    /**
     * @param s aab
     * @return [[a, a, b][aa, b]]
     */
    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[s.length()][s.length()];

        //初始化dp
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }

        dfs(s,0);
        return ans;
    }


    private void dfs(String s, int i) {
        if (i == n) {
            ans.add(new ArrayList<>(rst));
        }

        for (int j = i; j < n; j++) {
            //当前是回文
            if (dp[i][j]) {
                //写入
                rst.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                rst.remove(rst.size() - 1);
            }
        }
    }
}
