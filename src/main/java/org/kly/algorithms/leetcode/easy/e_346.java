package org.kly.algorithms.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class e_346 {

    public class MovingAverage {
        Queue<Integer> queue = new LinkedList<>();
        int nTotal;
        int count;
        int sum;

        public MovingAverage(int size) {
            count = size;
            nTotal = 0;
            sum = 0;
        }

        public double next(int val) {
            if (nTotal >= count) {
                int up = queue.poll();
                sum -= up;
                nTotal--;
            }
            queue.offer(val);
            sum += val;
            nTotal++;


            return (double) sum / nTotal;
        }
    }

    public static void main(String[] args) {
        MovingAverage average = new e_346().new MovingAverage(3);
        System.out.println(average.next(1));
        System.out.println(average.next(10));
        System.out.println(average.next(3));
        System.out.println(average.next(5));
    }
}
