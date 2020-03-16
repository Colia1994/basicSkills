package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * @Author Colia
 * @Date 2020/3/15.
 */
public class m_695_岛屿的最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        int i_length =  grid.length;
        int j_length = grid[0].length;
        int area =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    //登陆岛屿 判断该岛屿面积 同时标记岛屿已登记的为0
                    int area_in = getMaxArea(i,j,grid);
                    area = Math.max(area,area_in);
                }
            }
        }
        return area;
    }

    private int getMaxArea(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        //通过将经过的岛屿设置为0来确保下次不会重复访问
        grid[i][j] = 0;

        int upMaxArea = getMaxArea(i - 1, j, grid);

        int downMaxArea = getMaxArea(i + 1, j, grid);

        int leftMaxArea = getMaxArea(i, j - 1, grid);

        int rightMaxArea = getMaxArea(i, j + 1, grid);

        return upMaxArea + downMaxArea + leftMaxArea + rightMaxArea + 1;
    }



}
