package org.kly.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author colia
 * @date 2018/12/17 0:08
 */
public class m_6 {

    /**
     * my first answer
     * 按行填充 最后合并输出 不保证形状
     */
    public String convert(String s, int numRows) {


        if (numRows == 1) return s;
        StringBuilder stringBuilderResult = new StringBuilder();

        int height = Math.min(s.length(), numRows);
        List<StringBuilder> rows = new ArrayList<>();
        for (int j = 0; j < height; j++) {
            rows.add(new StringBuilder());
        }

        int row = 0;
        //方向
        boolean direction = false;
        for (int i = 0; i < s.length(); i++) {
            rows.get(row).append(s.charAt(i));
            if (row == height - 1 || row == 0) {
                direction = !direction;
            }
            if (direction) {
                row += 1;
            } else {
                row -= 1;
            }
        }

        for (StringBuilder stringBuilder : rows) {
            stringBuilderResult.append(stringBuilder);
        }
        return stringBuilderResult.toString();
    }


}
