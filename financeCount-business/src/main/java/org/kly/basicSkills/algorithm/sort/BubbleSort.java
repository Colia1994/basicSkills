package org.kly.basicSkills.algorithm.sort;

/**
 * 冒泡排序
 * 时间复杂度 O(n ^ 2)
 * 空间复杂度 O(1)
 * 稳定排序
 * @Author konglingyao
 * @Date 2018/12/28
 */
public class BubbleSort {

    public static void main( String[] args ) {
        Integer[] inputArray = {121,11,12,3,123,1,132,12,234,123,12,2435,123,123,13};
        inputArray = BubbleSort.bubbleSort(inputArray);
        for(Integer integer : inputArray) {
            System.out.println(integer);
        }

    }


    private static Integer[] bubbleSort(Integer[] inputArray) {

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 1; j < inputArray.length - i; j++) {
                if (inputArray[j] < inputArray[j - 1]) {
                    swap(inputArray, j, j - 1);
                }
            }
        }
        return inputArray;
    }

    private static void swap(Integer[] inputArray,int i ,int j) {
        int a = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = a;
    }
}
