package org.kly.algorithms.leetcode.medium;

import java.util.*;

/**
 * @author konglingyao
 * @date 2024/7/18
 */
public class m_3112 {

    /**
     * dp[i] = min(0~i);
     * n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5]
     */
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {

        //0～i 花费的最短时间
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int j = 0; j < edges.length; j++) {
            if (dp[edges[j][0]] == -1) {
                //前节点的最小可达时间 不存在，则此路不同，直接跳过
                continue;
            }
            int j_now_time = dp[edges[j][0]] + edges[j][2];
            if (j_now_time > disappear[edges[j][1]]) {
                //j此路径下会消失，则不可达
                if (dp[edges[j][1]] == 0) {
                    dp[edges[j][1]] = -1;
                }
            } else {
                //和当前路径取最短
                dp[edges[j][1]] = Math.min(dp[edges[j][1]], j_now_time);
            }
        }

        return dp;

    }


    public int[] minimumTime_ans(int n, int[][] edges, int[] disappear) {
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        //转换存储，方便找到任意节点的可达路径
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], length = edge[2];
            adj[u].add(new int[]{v, length});
            adj[v].add(new int[]{u, length});
        }
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{0, 0});
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        answer[0] = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            //t 到达u节点的当轮耗时
            int u = arr[0], t = arr[1];
            //如果当轮耗时等于已经记录的最低耗时，则无需更新后续轮次，即 从u出发的所有路径
//            if (t != answer[u]) {
//                continue;
//            }
            //若不相同，则需要找出 u为起点的所有路径，并判断到达点是否需要压入队列，（未超时且并当前结果更优）
            for (int[] next : adj[u]) {
                int v = next[0], length = next[1];
                if (t + length < disappear[v] && (answer[v] == -1 || t + length < answer[v])) {
                    pq.offer(new int[]{v, t + length});
                    answer[v] = t + length;
                }
            }
        }
        return answer;
    }
}
