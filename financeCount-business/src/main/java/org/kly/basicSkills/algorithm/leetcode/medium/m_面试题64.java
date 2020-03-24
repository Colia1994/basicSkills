package org.kly.basicSkills.algorithm.leetcode.medium;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 *
 * @Author Colia
 * @Date 2020/3/10.
 */
public class m_面试题64 {

    public int sumNums(int n) {
        int sum = n;
        boolean test = ((n > 0) && (sum += sumNums(sum - 1)) > 0);
        return sum;
    }
}
