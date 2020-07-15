package org.kly.algorithms.sort;

import org.kly.utils.ArrayUtils;
import org.kly.utils.PrintUtils;

/**
 * 简单选择排序
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 * 不稳定排序
 *
 * @Author konglingyao
 * @Date 2018/12/28
 */
public class SimpleSelectionSort {

    public static void main(String[] args) {
        Integer[] inputArray = {121, 11, 12, 3, 123, 1, 132, 12, 234, 123, 12, 2435, 123, 123, 13};
        SimpleSelectionSort.simpleSelect(inputArray);
        PrintUtils.printArray(inputArray);

    }

    private static void simpleSelect(Integer[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            int min = minInArray(inputArray, i, inputArray.length);
            if (inputArray[i] > inputArray[min]) {
                ArrayUtils.swap(inputArray, i, min);
            }
        }
    }

    private static int minInArray(Integer[] inputArray, int start, int end) {
        int min = start;
        for (int i = start + 1; i < end; i++) {
            if (inputArray[i] < inputArray[min]) {
                min = i;
            }
        }
        return min;
    }


}
