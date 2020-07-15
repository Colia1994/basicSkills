package org.kly.algorithms.sort;

import org.kly.utils.ArrayUtils;
import org.kly.utils.PrintUtils;

/**
 * 快排
 * 时间复杂度 O(n * log n)
 * 空间复杂度 O(n * log n)
 * 不稳定排序
 *
 * @Author konglingyao
 * @Date 2018/12/28
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] inputArray = {121, 11, 12, 3, 123, 1, 132, 12, 234, 123, 12, 2435, 123, 123, 13};
        QuickSort.quickSortAndSwapUp(inputArray, 0, inputArray.length - 1);
        PrintUtils.printArray(inputArray);

    }

    private static void quickSortAndSwapUp(Integer[] inputArray, int low, int high) {
        if (low < high) {
            PrintUtils.printArray(inputArray);
            int cu = partition(inputArray, low, high);
            quickSortAndSwapUp(inputArray, low, cu - 1);
            quickSortAndSwapUp(inputArray, cu + 1, high);
        }
    }

    private static int partition(Integer[] a, int low, int high) {
        int current = a[low];                                //基准元素
        while (low < high) {                                    //从表的两端交替地向中间扫描
            while (low < high && a[high] >= current) {
                --high;
            }  //从high 所指位置向前搜索，至多到low+1 位置。将比基准元素小的交换到低端
            ArrayUtils.swap(a, low, high);
            while (low < high && a[low] <= current) {
                ++low;
            }
            ArrayUtils.swap(a, low, high);
        }
        return low;
    }
}
