package org.kly.leetcode.medium;

/**
 *
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * Find the last number that remains starting with a list of length n.
 * Example:
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * Output:6
 *
 * @author colia
 * @date 2018/12/9 23:25
 */
public class EliminationGame {

    /**
     * Brute Force
     * 我的答案 900ms时间
     */
    public int lastRemainingBruteForce(int n) {
        int step = 1;
        int left = 1;
        int right = n;
        boolean solution = true;//true means left
        while (left != right) {
            if (solution) {
                left += step;
                step = step * 2;
                int maxSpace = right;
                right = left;
                while (right + step <= maxSpace) {
                    right += step;
                }

            } else {
                right -= step;
                step = step * 2;
                int minSpace = left;
                left = right;
                while (left - step >= minSpace) {
                    left -= step;
                }
            }
            solution = !solution;
        }
        return left;
    }

    /**
     * Brute Force优化版 40ms
     */
    public int lastRemainingBruteBest(int n) {
        int step = 1;
        int left = 1;
        int right = n;
        boolean solution = true;//true means left
        while (left != right) {
            int dif = right - left;
            if (solution) {
                left += step;
                if (dif % (2 * step) == 0) {
                    right -= step;
                }

            } else {
                right -= step;
                if (dif % (2 * step) == 0) {
                    left += step;
                }
            }
            step = step * 2;

            solution = !solution;
        }
        return left;
    }

    /**
     * 答案
     */
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 ==1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

}
