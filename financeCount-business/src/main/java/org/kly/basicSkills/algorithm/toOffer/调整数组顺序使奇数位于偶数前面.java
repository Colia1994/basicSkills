package org.kly.basicSkills.algorithm.toOffer;

import java.util.ArrayList;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author colia
 * @date 2018/12/30 20:53
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public void reOrderArray(int [] array) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i1 : array) {
            if (i1 % 2 == 1) {
                arrayList.add(i1);
            }
        }
        for (int i1 : array) {
            if (i1 % 2 == 0) {
                arrayList.add(i1);
            }
        }
        for (int i=0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
    }


}
