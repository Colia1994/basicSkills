package org.kly.basicSkills.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/3/31.
 */
public class m_22_括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        f(result, "(", 0, 0, "", n);
        return result;
    }

    private void f(List<String> result, String kh, int lnum, int rnum, String code, int n) {
        if (kh.equals("(") && lnum < n) {
            code += kh;
            lnum++;
        } else if (kh.equals(")") && rnum < lnum) {
            code += kh;
            rnum++;
        } else {
            return;
        }

        if (code.length() == 2 * n) {
            result.add(code);
        }
        f(result, "(", lnum, rnum, code, n);
        f(result, ")", lnum, rnum, code, n);

    }
}
