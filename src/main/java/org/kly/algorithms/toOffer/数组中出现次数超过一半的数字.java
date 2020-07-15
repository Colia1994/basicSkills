package org.kly.algorithms.toOffer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @author colia
 * @date 2019/1/1 20:41
 */
public class 数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null) {
            return 0;
        }
        int count = 1;
        int countNumber = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != countNumber) {
                count--;
            } else {
                count++;
            }
            if (count == 0) {
                countNumber = array[i];
                count++;
            }
        }
        count = 0;
        for (int l1 : array) {
            if (l1 == countNumber) {
                count++;
            }
        }
        if (count * 2 <= array.length) {
            return 0;
        }
        return countNumber;
    }

}
