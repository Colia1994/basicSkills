package org.kly.algorithms.leetcode.medium;

public class m_316 {

    public String removeDuplicateLetters(String s) {
        boolean[] visit = new boolean[26];

        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            // sb中不存在，直接添加
            if (!visit[s.charAt(i) - 'a']) {
                // 如果当前字符比最近一个还大，且最近一个后面还有，则删除该字符
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > s.charAt(i)) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        visit[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        // 即使字典不够小，但没这个字符了，不能删除
                        break;
                    }
                }
                sb.append(s.charAt(i));
                visit[s.charAt(i) - 'a'] = true;
            }
            num[s.charAt(i) - 'a'] -= 1;
        }
        return sb.toString();

    }
}
