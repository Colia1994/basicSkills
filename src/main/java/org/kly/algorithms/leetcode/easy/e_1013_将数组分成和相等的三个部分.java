package org.kly.algorithms.leetcode.easy;

/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * <p>
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 * @Author Colia
 * @Date 2020/3/11.
 */
public class e_1013_将数组分成和相等的三个部分 {

    public boolean canThreePartsEqualSum(int[] A) {

        int sum = 0;

        for (int i : A) {
            sum += i;
        }
        if (sum % 3 > 0) {
            return false;
        }
        int c = sum / 3;
        sum = 0;
        int flag = 2;
        for (int i : A) {
            sum += i;
            if (sum == c) {
                flag--;
                sum = 0;
            }
            if (flag < 0) {
                return true;
            }

        }

        return false;
    }
}
