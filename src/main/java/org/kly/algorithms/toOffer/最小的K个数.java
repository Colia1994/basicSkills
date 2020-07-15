package org.kly.algorithms.toOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * @author colia
 * @date 2019/1/1 21:01
 */
public class 最小的K个数 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input == null || k >= input.length) {
            return arrayList;
        }
        int low = 0;
        int high = input.length - 1;
        int index = partition(input, low, high);

        while (index != k - 1) {
            if (index > k - 1) {
                high = index - 1;
                index = partition(input, low, high);
            } else {
                low = index + 1;
                index = partition(input, low, high);
            }
        }


        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    private int partition(int[] a, int low, int high) {
        int current = a[low];
        while (low < high) {
            while (low < high && a[high] >= current) {
                --high;
            }
            swap(a, low, high);
            while (low < high && a[low] <= current) {
                ++low;
            }
            swap(a, low, high);

        }
        return low;
    }

    private void swap(int[] inputArray, int i, int j) {
        int a = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = a;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = input.length;
        if (k > length || k == 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i1 : input) {
            if (maxHeap.size() != k) {
                maxHeap.offer(i1);
            } else if (maxHeap.peek() > i1) {
                maxHeap.poll();
                maxHeap.offer(i1);
            }
        }
        result.addAll(maxHeap);
        return result;
    }
}
