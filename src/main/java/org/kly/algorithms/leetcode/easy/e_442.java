package org.kly.algorithms.leetcode.easy;

import java.util.List;

public class e_442 {

    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        for (int i = 0; i < n; i++) {
            if (words.get(i).length() > n) {
                return false;
            }
            for (int j = i + 1; j < n; j++) {
                char c1 = getCharacter(words, i, j);
                char c2 = getCharacter(words, j, i);
                if (c1 != c2) {
                    return false;
                }
            }
        }
        return true;
    }

    public char getCharacter(List<String> words, int row, int col) {
        String word = words.get(row);
        return col < word.length() ? word.charAt(col) : ' ';
    }
}
