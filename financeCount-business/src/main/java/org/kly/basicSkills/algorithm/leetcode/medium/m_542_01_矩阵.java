package org.kly.basicSkills.algorithm.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。示例 1:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Colia
 * @Date 2020/4/15.
 */
public class m_542_01_矩阵 {

    public int[][] updateMatrix(int[][] matrix) {
        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return matrix;
    }

    public int[][] updateMatrix1(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i = 0 ;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = -1;
                }
            }
        }
        for(int i = 0 ;i<m;i++){
            for(int j = 0;j<n;j++){
                res[i][j] = dfs(matrix,i,j,visited);
            }
        }

        return res;
    }

    private int dfs(int[][] matrix,int m, int n,boolean[][] visited){
        if(m<0 || n<0 || m>=matrix.length||n>=matrix[0].length){
            return 200000;
        }
        if(visited[m][n] && matrix[m][n] == -1){
            return 200000;
        }
        visited[m][n] = true;

        if(matrix[m][n] == 0){
            matrix[m][n] = 0;
            return 0;
        } else if(matrix[m][n] == -1){
            int up = dfs(matrix,m,n-1,visited)+1;
            int down = dfs(matrix,m,n+1,visited)+1;


            int left = dfs(matrix,m-1,n,visited)+1;

            int right = dfs(matrix,m+1,n,visited)+1;
            matrix[m][n] = Math.min(Math.min(up,down),Math.min(left,right));
            if(matrix[m][n] ==3){
                matrix[m][n] = Math.min(Math.min(up,down),Math.min(left,right));

            }
            return Math.min(Math.min(up,down),Math.min(left,right));
        } else {
            return matrix[m][n];
        }
    }
    /**
     * [
     * [1,0,1,1,0,0,1,0,0,1],
     * [0,1,1,0,1,0,1,0,1,1],
     * [0,0,1,0,1,0,0,1,0,0],
     * [1,0,1,0,1,1,1,1,1,1],
     * [0,1,0,1,1,0,0,0,0,1],
     * [0,0,1,0,1,1,1,0,1,0],
     * [0,1,0,1,0,1,0,0,1,1],
     * [1,0,0,0,1,1,1,1,0,1],
     * [1,1,1,1,1,1,1,0,1,0],
     * [1,1,1,1,0,1,0,0,1,1]
     * ]
     */

    public static void main(String[] args) {
        m_542_01_矩阵 m = new m_542_01_矩阵();
        int[][] matrix = new int[10][10];
        matrix[0] = new int[]{1,0,1,1,0,0,1,0,0,1};
        matrix[1] = new int[]{0,1,1,0,1,0,1,0,1,1};
        matrix[2] = new int[]{0,0,1,0,1,0,0,1,0,0};
        matrix[3] = new int[]{1,0,1,0,1,1,1,1,1,1};
        matrix[4] = new int[]{0,1,0,1,1,0,0,0,0,1};
        matrix[5] = new int[]{0,0,1,0,1,1,1,0,1,0};
        matrix[6] = new int[]{0,1,0,1,0,1,0,0,1,1};
        matrix[7] = new int[]{1,0,0,0,1,1,1,1,0,1};
        matrix[8] = new int[]{1,1,1,1,1,1,1,0,1,0};
        matrix[9] = new int[]{1,1,1,1,0,1,0,0,1,1};
        m.updateMatrix1(matrix);
    }
}
