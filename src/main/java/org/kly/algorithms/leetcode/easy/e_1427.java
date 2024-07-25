package org.kly.algorithms.leetcode.easy;

public class e_1427 {

    public String stringShift(String s, int[][] shift) {
        // 右移位数
        int offSet = 0;
        for(int[] every : shift) {
            if (every[0] == 0) {
                offSet += every[1];
            } else {
                offSet -= every[1];
            }
        }
        offSet = offSet % s.length();
        if (offSet < 0) {
            offSet = offSet + s.length();
        }

        String after = s.substring(0, offSet);
        String before = s.substring(offSet);
        return before + after;
    }
}
