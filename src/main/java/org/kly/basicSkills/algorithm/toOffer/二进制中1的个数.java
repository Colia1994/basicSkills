package org.kly.basicSkills.algorithm.toOffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author colia
 * @date 2018/12/30 20:33
 */
public class 二进制中1的个数 {

    /**
     * -1后与运算去掉二进制下左后一位1
     */
    public int NumberOf1(int n) {

        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

}
