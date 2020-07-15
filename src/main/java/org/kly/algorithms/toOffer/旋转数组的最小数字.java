package org.kly.algorithms.toOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author colia
 * @date 2018/12/30 19:21
 */
public class 旋转数组的最小数字 {

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = start;
        while (array[start] > array[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            //当start end mid三个指针的值相同时，需要退化为顺序查找 此处略
            if (array[mid] >= array[start]) {
                start = mid;
            }
            if (array[mid] <= array[end]) {
                end = mid;
            }
        }
        return array[mid];
    }
}
