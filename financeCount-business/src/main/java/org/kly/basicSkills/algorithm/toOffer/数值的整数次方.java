package org.kly.basicSkills.algorithm.toOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author colia
 * @date 2018/12/30 20:41
 */
public class 数值的整数次方 {

    public double Power(double base, int exponent) {

        if (exponent >= 0) {
            return power(base, exponent);
        } else {
            return 1.0 / power(base, -exponent);
        }
    }

    private double power(double base, int exponent) {
        double result = 1;
        while (exponent > 0) {
            result *= base;
            exponent--;
        }
        return result;
    }
}
