package org.kly.algorithms.tree;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 深度优先算法
 *
 * @author colia
 * @date 2018/12/11
 */
public class Dfs {

    public static void main(String[] args) {
        //构造各顶点
        LinkedList<Character> list_u = new LinkedList<>();
        list_u.add('v');
        list_u.add('x');
        LinkedList<Character> list_v = new LinkedList<>();
        list_v.add('y');
        LinkedList<Character> list_y = new LinkedList<>();
        list_y.add('x');
        LinkedList<Character> list_x = new LinkedList<>();
        list_x.add('v');
        LinkedList<Character> list_w = new LinkedList<>();
        list_w.add('y');
        list_w.add('z');
        LinkedList<Character> list_z = new LinkedList<>();
        list_z.add('w');
        //构造图
        HashMap<Character, LinkedList<Character>> graph = new HashMap<>();
        graph.put('u', list_u);
        graph.put('v', list_v);
        graph.put('y', list_y);
        graph.put('x', list_x);
        graph.put('w', list_w);
        graph.put('z', list_z);

        HashMap<Character, Boolean> visited = new HashMap<>();
        //调用深度优先遍历方法
        dfs(graph, visited);
    }

    private static void dfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Boolean> visited) {
        visit(graph, visited, 'u');// 为了和图中的顺序一样，我认为控制了DFS先访问u节点
        visit(graph, visited, 'w');
    }

    //通过一个全局变量count记录了进入每个节点和离开每个节点的时间
    private static int count;

    private static void visit(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Boolean> visited,
                              char start) {
        if (!visited.containsKey(start)) {
            count++;
            System.out.println("The time into element " + start + ":" + count);// 记录进入该节点的时间
            visited.put(start, true);
            // 递归访问其邻近节点
            graph.get(start).stream().filter(c -> !visited.containsKey(c)).forEach(c -> {
                visit(graph, visited, c);// 递归访问其邻近节点
            });
            count++;
//            System.out.println("The time out element " + start + ":" + count);// 记录离开该节点的时间
        }
    }

}
