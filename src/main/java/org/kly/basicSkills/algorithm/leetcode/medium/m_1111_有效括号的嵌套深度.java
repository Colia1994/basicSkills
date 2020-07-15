package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * @Author Colia
 * @Date 2020/4/1.
 */
public class m_1111_有效括号的嵌套深度 {

    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int idx = 0;
        for (char c : seq.toCharArray()) {
            ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
        }
        return ans;
    }
}
