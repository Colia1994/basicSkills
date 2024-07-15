package org.kly.algorithms.leetcode.easy;

/**
 * @Author konglingyao
 * @Date 2023/5/17
 */
public class e_2446 {

    public boolean haveConflict(String[] event1, String[] event2) {
        int s1 = Integer.parseInt(event1[0].replace(":", ""));
        int e1 = Integer.parseInt(event1[1].replace(":", ""));
        int s2 = Integer.parseInt(event2[0].replace(":", ""));
        int e2 = Integer.parseInt(event2[1].replace(":", ""));

        return !(s1 < s2 && e1 < s2) && !(s1 > e2 && e1 > e2);
    }
}
