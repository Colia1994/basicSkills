package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/3/30.
 */
public class m_63_不同路径_II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;


        //预先计算dp函数 便可知
        //-1 代表一种走法 1 代表障碍物
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                obstacleGrid[0][i] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                obstacleGrid[i][0] = -1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int x = obstacleGrid[i - 1][j] == 1 ? 0 : obstacleGrid[i - 1][j];
                int y = obstacleGrid[i][j - 1] == 1 ? 0 : obstacleGrid[i][j - 1];
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 1 : (x + y);
            }
        }
        if (obstacleGrid[m - 1][n - 1] > 0) {
            return 0;
        } else {
            return -obstacleGrid[m - 1][n - 1];
        }
    }
}
