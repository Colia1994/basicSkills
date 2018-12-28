package org.kly.basicSkills.algorithm.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先算法
 * @author colia
 * @date 2018/12/11
 */
public class Bfs {
    public static void main(String[] args) {

        //构造各顶点
        LinkedList<Character> list_s = new LinkedList<>();
        list_s.add('w');
        list_s.add('r');
        LinkedList<Character> list_w = new LinkedList<>();
        list_w.add('s');
        list_w.add('i');
        list_w.add('x');
        LinkedList<Character> list_r = new LinkedList<>();
        list_r.add('s');
        list_r.add('v');
        LinkedList<Character> list_x = new LinkedList<>();
        list_x.add('w');
        list_x.add('i');
        list_x.add('u');
        list_x.add('y');
        LinkedList<Character> list_v = new LinkedList<>();
        list_v.add('r');
        LinkedList<Character> list_i = new LinkedList<>();
        list_i.add('u');
        list_i.add('x');
        list_i.add('w');
        LinkedList<Character> list_u = new LinkedList<>();
        list_u.add('i');
        list_u.add('x');
        list_u.add('y');
        LinkedList<Character> list_y = new LinkedList<>();
        list_y.add('u');
        list_y.add('x');

        //构造图
        HashMap<Character, LinkedList<Character>> graph = new HashMap<>();
        graph.put('s', list_s);
        graph.put('w', list_w);
        graph.put('r', list_r);
        graph.put('x', list_x);
        graph.put('v', list_v);
        graph.put('i', list_i);
        graph.put('y', list_y);
        graph.put('u', list_u);
        //记录每个顶点离起始点的距离，也即最短距离
        HashMap<Character, Integer> dist = new HashMap<>();
        //遍历的起始点
        char start = 's';
        //调用广度优先方法
        bfs(graph, dist, start);
    }

    private static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist,
                            char start) {
        Queue<Character> q = new LinkedList<>();
        q.add(start);// 将s作为起始顶点加入队列
        dist.put(start, 0);
        int i = 0;
        while (!q.isEmpty()) {
            char top = q.poll();// 取出队首元素
            i++;
            System.out.println("The " + i + "th element:" + top + " Distance from s is:" + dist.get(top));
            int d = dist.get(top) + 1;// 得出其周边还未被访问的节点的距离
            // 如果dist中还没有该元素说明还没有被访问
            graph.get(top).stream().filter(c -> !dist.containsKey(c)).forEach(c -> {
                dist.put(c, d);
                q.add(c);
            });
        }
    }
}
