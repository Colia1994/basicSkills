package org.kly.algorithms.leetcode.medium;

import java.util.*;

/**
 * @author konglingyao
 * @date 2024/7/16
 */
public class m_36 {

    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!verifyKey(i, j, board,map)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verifyKey(int x, int y, char[][] board, Map<String, Set<Character>> map) {
        if (board[x][y] == '.') {
            return true;
        }

        List<String> list = new ArrayList<>();
        list.add("X" + y);
        list.add(x + "Y");

        //判断子宫格 一次只会出现一个
        list.add(((x / 3 * 3) + 1) + "" + ((y / 3 * 3) + 1));

        for (String s : list) {
            if (map.containsKey(s)) {
                if (map.get(s).contains(board[x][y])) {
                    return false;
                } else {
                    map.get(s).add(board[x][y]);
                }
            } else {
                map.put(s, new HashSet<>());
                map.get(s).add(board[x][y]);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '2'},
                {'.', '.', '.', '.', '.', '.', '6', '.', '.'},
                {'.', '.', '1', '4', '.', '.', '8', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '3', '.', '.', '.', '.'},
                {'5', '.', '8', '6', '.', '.', '.', '.', '.'},
                {'.', '9', '.', '.', '.', '.', '4', '.', '.'},
                {'.', '.', '.', '.', '5', '.', '.', '.', '.'}
        };

        m_36 m = new m_36();
        m.isValidSudoku(board);

    }

}
