package org.kly.algorithms.leetcode.medium;

/**
 * @Author konglingyao
 * @Date 2023/5/10
 */
public class m_1015 {

    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int resid = 1 % k, len = 1; // resid为余数，len为数字长度，初始值为1

        while (resid != 0) { // 当余数为0时退出循环
            resid = (resid * 10 + 1) % k; // 计算下一个余数
            len++; // 数字长度+1

        }
        return len; // 返回数字长度
    }
}
