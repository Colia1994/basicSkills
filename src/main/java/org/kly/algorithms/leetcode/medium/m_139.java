package org.kly.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konglingyao
 * @date 2024/7/25
 */
public class m_139 {


    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {
                if (dp[j]) {
                    dp[i] = dp[i] || wordDict.contains(s.substring(j, i ));
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        m_139 obj = new m_139();
        System.out.println(obj.wordBreak("aaaaaaa", new ArrayList<String>() {{
            add("aaaa");
            add("aaa");

        }}));
    }

}
