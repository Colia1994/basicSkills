package org.kly.algorithms.leetcode.hard;

import com.alibaba.fastjson.JSON;
import net.minidev.json.JSONUtil;

import javax.json.Json;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @Author konglingyao
 * @Date 2023/5/8
 */
public class TestAlgorithms {


    public int minPushBox(char[][] grid) {
        //定位S T B
        int x = grid.length;
        int y = grid[0].length;
        //寻找B T S
        int x_b = 0, y_b = 0;
        int x_s = 0, y_s = 0, x_t = 0, y_t = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 'B') {
                    x_b = i;
                    y_b = j;
                }
                if (grid[i][j] == 'T') {
                    x_t = i;
                    y_t = j;
                }
                if (grid[i][j] == 'S') {
                    x_s = i;
                    y_s = j;
                }
            }
        }
        int[][] s = new int[x][y];
        int[][] t = new int[x][y];

        s[x_b][y_b] = -1;

//        run_s(grid, s, t, x_b, y_b, x, y);
        run_t(grid, s, t, x_b, y_b, x, y);
        if (s[x_s][y_s] == 1) {
            return t[x_t][y_t] == 0 ? -1 : t[x_t][y_t];
        }
        //从b开始走一遍
        return -1;

    }

    private void run_s(char[][] grid, int[][] s, int x_b, int y_b, int x, int y) {

        if (x_b - 1 >= 0 && grid[x_b - 1][y_b] != '#' && s[x_b - 1][y_b] == 0) {
            //可以左移
            switch (grid[x_b - 1][y_b]) {
                case 'T':
                case 'S':
                case '.':
                    s[x_b - 1][y_b] = 1;
                    break;
                default:
                    s[x_b - 1][y_b] = -1;
            }
            run_s(grid, s, x_b - 1, y_b, x, y);
        }
        if (x_b + 1 < x && grid[x_b + 1][y_b] != '#' && s[x_b + 1][y_b] == 0) {
            //可以右移
            switch (grid[x_b + 1][y_b]) {
                case 'T':
                case 'S':
                case '.':
                    s[x_b + 1][y_b] = 1;
                    break;
                default:
                    s[x_b + 1][y_b] = -1;
            }
            run_s(grid, s, x_b + 1, y_b, x, y);
        }
        if (y_b - 1 >= 0 && grid[x_b][y_b - 1] != '#' && s[x_b][y_b - 1] == 0) {
            //可以上移
            switch (grid[x_b][y_b - 1]) {
                case 'T':
                case 'S':
                case '.':
                    s[x_b][y_b - 1] = 1;
                    break;
                default:
                    s[x_b][y_b - 1] = -1;
            }
            run_s(grid, s, x_b, y_b - 1, x, y);
        }
        if (y_b + 1 < y && grid[x_b][y_b + 1] != '#' && s[x_b][y_b + 1] == 0) {
            // 可以下移
            switch (grid[x_b][y_b + 1]) {
                case 'T':
                case 'S':
                case '.':
                    s[x_b][y_b + 1] = 1;
                    break;
                default:
                    s[x_b][y_b + 1] = -1;
            }
            run_s(grid, s, x_b, y_b + 1, x, y);
        }
    }

    private void run_t(char[][] grid, int[][] s, int[][] t, int x_b, int y_b, int x, int y) {

        if (x_b - 1 >= 0 && grid[x_b - 1][y_b] != '#' && t[x_b - 1][y_b] == 0 && grid[x_b + 1][y_b] != '#') {
            //可以左移
            t[x_b - 1][y_b] = t[x_b][y_b] + 1;
            run_t(grid, s, t, x_b - 1, y_b, x, y);
        }
        if (x_b + 1 < x && grid[x_b + 1][y_b] != '#' && t[x_b + 1][y_b] == 0 && grid[x_b - 1][y_b] != '#') {
            //可以右移

            t[x_b + 1][y_b] = t[x_b][y_b] + 1;

            run_t(grid, s, t, x_b + 1, y_b, x, y);
        }
        if (y_b - 1 >= 0 && grid[x_b][y_b - 1] != '#' && grid[x_b][y_b + 1] != '#' && t[x_b][y_b - 1] == 0) {
            //可以上移
            t[x_b][y_b - 1] = t[x_b][y_b] + 1;
            run_t(grid, s, t, x_b, y_b - 1, x, y);
        }
        if (y_b + 1 < y && grid[x_b][y_b + 1] != '#' && grid[x_b][y_b - 1] != '#' && t[x_b][y_b + 1] == 0) {
            // 可以下移
            t[x_b][y_b + 1] = t[x_b][y_b] + 1;
            run_t(grid, s, t, x_b, y_b + 1, x, y);
        }
    }

//    public static void main(String[] args) {
//        char[][] gird = new char[][]{{'#', '#', '#', '#', '#', '#'}, {'#', 'T', '.', '.', '#', '#'}, {'#', '.', '#', 'B', '.', '#'}, {'#', '.', '.', '.', '.', '#'}, {'#', '.', '.', '.', 'S', '#'}, {'#', '#', '#', '#', '#', '#'}};
//        TestAlgorithms testAlgorithms = new TestAlgorithms();
//        System.out.printf(testAlgorithms.minPushBox(gird) + "");
//    }

    //示例 1：
    //
    //输入：time = "?5:00"
    //输出：2
    //解释：我们可以将 ? 替换成 0 或 1 ，得到 "05:00" 或者 "15:00" 。注意我们不能替换成 2 ，因为时间 "25:00" 是无效时间。所以我们有两个选择。
    //示例 2：
    //
    //输入：time = "0?:0?"
    //输出：100
    //解释：两个 ? 都可以被 0 到 9 之间的任意数字替换，所以我们总共有 100 种选择。
    //示例 3：
    //
    //输入：time = "??:??"
    //输出：1440
    //解释：小时总共有 24 种选择，分钟总共有 60 种选择。所以总共有 24 * 60 = 1440 种选择。
    public static void main(String[] args) {
        TestAlgorithms testAlgorithms = new TestAlgorithms();
        System.out.printf(String.valueOf(testAlgorithms.countTime("07:?3")));
    }


    public int countTime(String time) {
        if (time.length() != 5) {
            return -1;
        }

        if (time.charAt(2) != ':') {
            return -1;
        }
        int result = 1;
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            result *= 24;
        } else if ((time.charAt(0) == '0' || time.charAt(0) == '1') && time.charAt(1) == '?') {
            result *= 10;
        } else if (time.charAt(0) == '2' && time.charAt(1) == '?') {
            result *= 4;
        } else if (time.charAt(0) == '?' && time.charAt(1) - '0' > 3) {
            result *= 2;
        } else if (time.charAt(0) == '?' && time.charAt(1) - '0' < 4) {
            result *= 3;
        }

        if (time.charAt(3) == '?' && time.charAt(4) == '?') {
            result *= 60;
        } else if (time.charAt(3) == '?') {
            result *= 6;
        } else if (time.charAt(4) == '?') {
            result *= 10;
        }

        return result;
    }
    /**
     * {
     * {'#','#','#','#','#','#'},
     * {'#','T','.','.','#','#'},
     * {'#','.','#','B','.','#'},
     * {'#','.','.','.','.','#'},
     * {'#','.','.','.','S','#'},
     * {'#','#','#','#','#','#'}
     * }
     *
     */

    /**
     * [
     * ["#",".",".","#","#","#","#","#"],
     * ["#",".",".","T","#",".",".","#"],
     * ["#",".",".",".","#","B",".","#"],
     * ["#",".",".",".",".",".",".","#"],
     * ["#",".",".",".","#",".","S","#"],
     * ["#",".",".","#","#","#","#","#"]]
     */
}
