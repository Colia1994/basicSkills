package org.kly.algorithms.leetcode.hard;

import java.util.*;

/**
 * @Author konglingyao
 * @Date 2023/5/8
 */
public class TestAlgorithms {

    public static void main(String[] args) {
        TestAlgorithms testAlgorithms = new TestAlgorithms();
        boolean res = testAlgorithms.haveConflict(new String[]{"01:00", "02:00"}, new String[]{"02:00", "04:00"});
        System.out.println(res);
    }

    public boolean haveConflict(String[] event1, String[] event2) {
        int s1 = Integer.parseInt(event1[0].replace(":", ""));
        int e1 = Integer.parseInt(event1[1].replace(":", ""));
        int s2 = Integer.parseInt(event2[0].replace(":", ""));
        int e2 = Integer.parseInt(event2[1].replace(":", ""));

        return !(s1 < s2 && e1 < s2) && !(s1 > e2 && e1 > e2);
    }


}
