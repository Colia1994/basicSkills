package org.kly.algorithms.leetcode.easy;

public class e_202 {


    public boolean isHappy(int n) {
        int slow = n;
        int fast = cal(n);
        while (fast != slow && fast != 1) {
            slow = cal(slow);
            fast = cal(cal(fast));
        }

        return fast == 1;
    }


    private int cal(int n) {
        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n = n / 10;
        }
        return res;
    }
}
