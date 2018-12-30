package org.kly.basicSkills.algorithm.toOffer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author colia
 * @date 2018/12/30 20:28
 */
public class 矩形覆盖 {

    public int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        int pre = 1;
        int in = 1;
        int result = 1;
        for (int i = 2; i <= target; i++) {
            result = pre + in;
            pre = in;
            in = result;
        }
        return result;
    }
}
