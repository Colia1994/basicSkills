package org.kly.infrastructure.utils;

/**
 * 数组工具类
 *
 * @author colia
 * @date 2018/12/29 1:38
 */
public class ArrayUtils {

    public static void swap(Integer[] inputArray, int i, int j) {
        int a = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = a;
    }

    public static void swap(int[] inputArray, int i, int j) {
        int a = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = a;
    }
}
