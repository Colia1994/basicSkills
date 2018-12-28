package org.kly.basicSkills.algorithm.sort;

/**
 * 快排
 * 时间复杂度 O( n * log n)  空间复杂度O(n * log n)
 * 不稳定排序
 * @Author konglingyao
 * @Date 2018/12/28
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] inputArray = {121, 11, 12, 3, 123, 1, 132, 12, 234, 123, 12, 2435, 123, 123, 13};
        inputArray = QuickSort.quickSortAndSwapUp(inputArray,0,inputArray.length-1);
        for (Integer integer : inputArray) {
            System.out.println(integer);
        }

    }

    private static Integer[] quickSortAndSwapUp(Integer[] inputArray,int low,int high) {
        if (low < high) {
            int cu = partition(inputArray, low, high);
            quickSortAndSwapUp(inputArray, low, cu - 1);
            quickSortAndSwapUp(inputArray, cu + 1, high);
        }
        return inputArray;
    }

    private static int partition(Integer[] a, int low, int high) {
        int current = a[low];                                //基准元素
        while (low < high) {                                    //从表的两端交替地向中间扫描
            while (low < high && a[high] >= current) {
                --high;
            }  //从high 所指位置向前搜索，至多到low+1 位置。将比基准元素小的交换到低端
            swap(a, low, high);
            while (low < high && a[low] <= current) {
                ++low;
            }
            swap(a, low, high);
        }
        return low;
    }

    private static void swap(Integer[] inputArray,int i ,int j) {
        int a = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = a;
    }
}
