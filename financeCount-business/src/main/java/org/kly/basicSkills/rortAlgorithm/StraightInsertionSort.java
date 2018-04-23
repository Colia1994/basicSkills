package org.kly.basicSkills.rortAlgorithm;

/**
 *  插入排序-直接插入排序
 *  时间复杂度O（n^2）
 * @author colia
 * @date 2017-07-18
 */
public class StraightInsertionSort {

    public static void main( String[] args ) {
        Integer[] inputArray = {121,11,12,3,123,1,132,12,234,123,12,2435,123,123,13};
        inputArray = StraightInsertionSort.straightSortDown(inputArray);
        for(Integer integer : inputArray) {
            System.out.println(integer);
        }

    }

    /**
     *  升序排序　选出哨兵，向前插入，确保每一次比较的数组位置，前半部分为已排好顺序的
     */
    private static Integer[] straightSortUp(Integer[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] < inputArray[i - 1]) {
                int sentinel = inputArray[i]; //等待重新插入的哨兵
                inputArray[i] = inputArray[i - 1]; //  前面值大的后移一位，待后面循环继续判断
                //哨兵　向前排序
                int j = i - 1;
                while (j >= 0 && sentinel < inputArray[j]) {
                    inputArray[j + 1] = inputArray[j];//向前遍历
                    j--;
                }
                inputArray[j + 1] = sentinel;
            }
        }

        return inputArray;
    }

    /**
     *  降序排序　选出哨兵，向前插入，确保每一次比较的数组位置，前半部分为已排好顺序的
     */
    private static Integer[] straightSortDown(Integer[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > inputArray[i - 1]) {
                int sentinel = inputArray[i]; //等待重新插入的哨兵
                inputArray[i] = inputArray[i - 1]; //  前面值小的后移一位，待后面循环继续判断
                //哨兵　向前排序
                int j = i - 1;
                while (j >= 0 && sentinel > inputArray[j]) {
                    inputArray[j + 1] = inputArray[j];//向前遍历
                    j--;
                }
                inputArray[j + 1] = sentinel;
            }
        }

        return inputArray;
    }
}
