package org.kly.basicSkills.algorithm.leetcode.easy;

/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * <p>
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 * <p>
 * 返回车能够在一次移动中捕获到的卒的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/available-captures-for-rook
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/3/26.
 */
public class e_999_车的可用捕获量 {

    public int numRookCaptures(char[][] board) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int count = 0;
        int x1 = x, x2 = x, y1 = y, y2 = y;
        while (x1 >= 0) {
            if (board[x1][y] == 'p') {
                count++;
                break;
            } else if (board[x1][y] == 'B') {
                break;
            }
            x1--;
        }
        while (x2 < 8) {
            if (board[x2][y] == 'p') {
                count++;
                break;
            } else if (board[x2][y] == 'B') {
                break;
            }
            x2++;
        }
        while (y1 >= 0) {
            if (board[x][y1] == 'p') {
                count++;
                break;
            } else if (board[x][y1] == 'B') {
                break;
            }
            y1--;
        }
        while (y2 < 8) {
            if (board[x][y2] == 'p') {
                count++;
                break;
            } else if (board[x][y2] == 'B') {
                break;
            }
            y2++;
        }
        return count;
    }
}
