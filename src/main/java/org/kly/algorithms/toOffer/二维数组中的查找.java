package org.kly.algorithms.toOffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author colia
 * @date 2018/12/30 17:18
 */
public class 二维数组中的查找 {

    public boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int startX = array.length - 1;
        int startY = 0;

        while (startX >= 0 && startY < array[0].length) {

            if (array[startY][startX] > target) {
                startX--;
            } else if (array[startY][startX] == target) {
                return true;
            } else {
                startY++;
            }

        }
        return false;
    }
}
