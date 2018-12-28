package org.kly.basicSkills.algorithm.sort;

/**
 * 简单选择排序
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 * 不稳定排序
 * @Author konglingyao
 * @Date 2018/12/28
 */
public class SimpleSelectionSort {

    public static void main( String[] args ) {
        Integer[] inputArray = {121,11,12,3,123,1,132,12,234,123,12,2435,123,123,13};
        inputArray = SimpleSelectionSort.simpleSelect(inputArray);
        for(Integer integer : inputArray) {
            System.out.println(integer);
        }

    }

    private static Integer[] simpleSelect(Integer[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            int min = minInArray(inputArray, i, inputArray.length);
            if (inputArray[i] > inputArray[min]) {
                swap(inputArray, i, min);
            }
        }
        return inputArray;
    }

    private static int minInArray(Integer[] inputArray,int start,int end) {
        int min = start;
        for (int i = start + 1; i < end; i++) {
            if (inputArray[i] < inputArray[min]) {
                min = i;
            }
        }
        return min;
    }

    private static void swap(Integer[] inputArray,int i ,int j) {
        int a = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = a;
    }
}
