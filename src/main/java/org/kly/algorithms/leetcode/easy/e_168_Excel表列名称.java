package org.kly.algorithms.leetcode.easy;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 * <p>
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 * <p>
 * 输入: 701
 * 输出: "ZY"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author colia
 * @date 2020/1/10 12:05
 */
public class e_168_Excel表列名称 {


    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            int x = n % 26;
            x = x == 0 ? 26 : x;
            result.insert(0, (char) (x + 64));
            n = (n - x) / 26;
        }

        return result.toString();
    }
}
