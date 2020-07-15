package org.kly.utils;

/**
 * @author colia
 * @date 2018/12/29 1:27
 */
public class PrintUtils {

    public static void printArray(Integer[] inputArray) {
        if (inputArray == null) {
            return;
        }
        System.out.print("[");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i]);
            if (i < inputArray.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void printArray(int[] inputArray) {
        if (inputArray == null) {
            return;
        }
        System.out.print("[");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i]);
            if (i < inputArray.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
