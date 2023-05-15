package org.kly.algorithms.leetcode.hard;

import java.util.*;

public class h_1263_推箱子 {

    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sx = -1, sy = -1, bx = -1, by = -1; // 玩家、箱子的初始位置
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 'S') {
                    sx = x;
                    sy = y;
                } else if (grid[x][y] == 'B') {
                    bx = x;
                    by = y;
                }
            }
        }

        int[] d = {0, -1, 0, 1, 0};

        int[][] dp = new int[m * n][m * n];
        for (int i = 0; i < m * n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<int[]>();


        dp[sx * n + sy][bx * n + by] = 0; // 初始状态的推动次数为 0
        queue.offer(new int[]{sx * n + sy, bx * n + by});
        while (!queue.isEmpty()) {
            Queue<int[]> queue1 = new ArrayDeque<int[]>();
            while (!queue.isEmpty()) {
                int[] arr = queue.poll();
                int s1 = arr[0], b1 = arr[1];
                int sx1 = s1 / n, sy1 = s1 % n, bx1 = b1 / n, by1 = b1 % n;
                if (grid[bx1][by1] == 'T') { // 箱子已被推到目标处
                    return dp[s1][b1];
                }
                for (int i = 0; i < 4; i++) { // 玩家向四个方向移动到另一个状态
                    int sx2 = sx1 + d[i], sy2 = sy1 + d[i + 1], s2 = sx2*n+sy2;
                    if (!ok(grid, m, n, sx2, sy2)) { // 玩家位置不合法
                        continue;
                    }
                    if (bx1 == sx2 && by1 == sy2) { // 推动箱子
                        int bx2 = bx1 + d[i], by2 = by1 + d[i + 1], b2 = bx2*n+by2;
                        if (!ok(grid, m, n, bx2, by2) || dp[s2][b2] <= dp[s1][b1] + 1) { // 箱子位置不合法 或 状态已访问
                            continue;
                        }
                        dp[s2][b2] = dp[s1][b1] + 1;
                        queue1.offer(new int[]{s2, b2});
                    } else {
                        if (dp[s2][b1] <= dp[s1][b1]) { // 状态已访问
                            continue;
                        }
                        dp[s2][b1] = dp[s1][b1];
                        queue.offer(new int[]{s2, b1});
                    }
                }
            }
            queue = queue1;
        }
        return -1;
    }

    public boolean ok(char[][] grid, int m, int n, int x, int y) { // 不越界且不在墙上
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '#';
    }

    int x_b = 0, y_b = 0;
    int x_s = 0, y_s = 0, x_t = 0, y_t = 0;
    int minT = 0;

    public int minPushBox2(char[][] grid) {
        //定位S T B
        int x = grid.length;
        int y = grid[0].length;
        //寻找B T S

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
        int[][] t = new int[x][y];


        bfsBox(grid, t, x_b, y_b);
        return t[x_t][y_t] == 0 ? -1 : t[x_t][y_t];
    }

    private boolean dfsPersona(char[][] grid, int x_b, int y_b, int x_black_hole, int y_black_hole) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] s = new int[x][y];

        run_s(grid, s, x_b, y_b, x_black_hole, y_black_hole);
        return s[x_s][y_s] == 1;
    }

    private void run_s(char[][] grid, int[][] s, int x_b, int y_b, int x_black_hole, int y_black_hole) {
        int x = grid.length;
        int y = grid[0].length;
        if (x_b - 1 >= 0 && grid[x_b - 1][y_b] != '#' && s[x_b - 1][y_b] == 0) {
            //可以左移
            switch (grid[x_b - 1][y_b]) {
                case 'T':
                case 'S':
                case '.':
                    if (x_b - 1 == x_black_hole && y_b == y_black_hole) {
                        s[x_b - 1][y_b] = -1;
                    } else {
                        s[x_b - 1][y_b] = 1;
                        run_s(grid, s, x_b - 1, y_b, x, y);
                    }
                    break;
                default:
                    s[x_b - 1][y_b] = -1;
            }
        }
        if (x_b + 1 < x && grid[x_b + 1][y_b] != '#' && s[x_b + 1][y_b] == 0) {
            //可以右移
            switch (grid[x_b + 1][y_b]) {
                case 'T':
                case 'S':
                case '.':
                    if (x_b + 1 == x_black_hole && y_b == y_black_hole) {
                        s[x_b + 1][y_b] = -1;
                    } else {
                        s[x_b + 1][y_b] = 1;
                        run_s(grid, s, x_b + 1, y_b, x, y);
                    }
                    break;
                default:
                    s[x_b + 1][y_b] = -1;
            }
        }
        if (y_b - 1 >= 0 && grid[x_b][y_b - 1] != '#' && s[x_b][y_b - 1] == 0) {
            //可以上移
            switch (grid[x_b][y_b - 1]) {
                case 'T':
                case 'S':
                case '.':
                    if (x_b == x_black_hole && y_b - 1 == y_black_hole) {
                        s[x_b][y_b - 1] = -1;
                    } else {
                        s[x_b][y_b - 1] = 1;
                        run_s(grid, s, x_b, y_b - 1, x, y);
                    }
                    break;
                default:
                    s[x_b][y_b - 1] = -1;
            }
        }
        if (y_b + 1 < y && grid[x_b][y_b + 1] != '#' && s[x_b][y_b + 1] == 0) {
            // 可以下移
            switch (grid[x_b][y_b + 1]) {
                case 'T':
                case 'S':
                case '.':
                    if (x_b == x_black_hole && y_b + 1 == y_black_hole) {
                        s[x_b][y_b + 1] = -1;
                    } else {
                        s[x_b][y_b + 1] = 1;
                        run_s(grid, s, x_b, y_b + 1, x, y);
                    }
                    break;
                default:
                    s[x_b][y_b + 1] = -1;
            }
        }
    }

    private void run_t(char[][] grid, int[][] t, int x_b, int y_b) {
        int x = grid.length;
        int y = grid[0].length;
        if (grid[x_b][y_b] == 'T') {
            minT = Math.min(minT, t[x_t][y_t]);
        }


        if (x_b - 1 >= 0 && grid[x_b - 1][y_b] != '#' && grid[x_b + 1][y_b] != '#'
                && dfsPersona(grid, x_b + 1, y_b, x_b, y_b)) {
            //可以上移
            t[x_b - 1][y_b] = t[x_b][y_b] + 1;
            run_t(grid, t, x_b - 1, y_b);
        }
        if (x_b + 1 < x && grid[x_b + 1][y_b] != '#' && grid[x_b - 1][y_b] != '#'
                && dfsPersona(grid, x_b - 1, y_b, x_b, y_b)) {
            //可以下移

            t[x_b + 1][y_b] = t[x_b][y_b] + 1;

            run_t(grid, t, x_b + 1, y_b);
        }
        if (y_b - 1 >= 0 && grid[x_b][y_b - 1] != '#' && grid[x_b][y_b + 1] != '#' && dfsPersona(grid, x_b, y_b + 1, x_b, y_b)) {
            //可以左移
            t[x_b][y_b - 1] = t[x_b][y_b] + 1;
            run_t(grid, t, x_b, y_b - 1);
        }
        if (y_b + 1 < y && grid[x_b][y_b + 1] != '#' && grid[x_b][y_b - 1] != '#' && dfsPersona(grid, x_b, y_b - 1, x_b, y_b)) {
            // 可以右移
            t[x_b][y_b + 1] = t[x_b][y_b] + 1;
            run_t(grid, t, x_b, y_b + 1);
        }
    }




    private void bfsBox(char[][] grid, int[][] t, int x_b, int y_b) {
        int x = grid.length;
        int y = grid[0].length;
        //存储待处理的坐标
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x_b, y_b});
        while (!queue.isEmpty()) {
            int[] box = queue.pop();
            x_b = box[0];
            y_b = box[1];
            if (x_b - 1 >= 0 && grid[x_b - 1][y_b] != '#' && grid[x_b + 1][y_b] != '#'
                    && dfsPersona(grid, x_b + 1, y_b, x_b, y_b)) {
                t[x_b - 1][y_b] = t[x_b][y_b] + 1;
                queue.offerLast(new int[]{x_b - 1, y_b});
            }
            if (x_b + 1 < x && grid[x_b + 1][y_b] != '#' && grid[x_b - 1][y_b] != '#'
                    && dfsPersona(grid, x_b - 1, y_b, x_b, y_b)) {
                t[x_b + 1][y_b] = t[x_b][y_b] + 1;
                queue.offerLast(new int[]{x_b + 1, y_b});
            }
            if (y_b - 1 >= 0 && grid[x_b][y_b - 1] != '#' && grid[x_b][y_b + 1] != '#' && dfsPersona(grid, x_b, y_b + 1, x_b, y_b)) {
                t[x_b][y_b - 1] = t[x_b][y_b] + 1;
                queue.offerLast(new int[]{x_b, y_b - 1});
            }
            if (y_b + 1 < y && grid[x_b][y_b + 1] != '#' && grid[x_b][y_b - 1] != '#' && dfsPersona(grid, x_b, y_b - 1, x_b, y_b)) {
                t[x_b][y_b + 1] = t[x_b][y_b] + 1;
                queue.offerLast(new int[]{x_b, y_b + 1});
            }
        }
    }
}
