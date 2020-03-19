package org.kly.basicSkills.algorithm.leetcode.easy;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 * @Author Colia
 * @Date 2020/3/19.
 */
public class e_461_汉明距离 {

    public int hammingDistance(int x, int y) {

        int xor = x ^ y;
        return hammingWeightBit(xor);
    }

    public int hammingWeightBit(int n) {
        int count = 0;
        while (n != 0){
            count++;
            //每运行一次 就把最右边的1置为0
            n &= (n-1);
        }
        return count;
    }
}
