package org.kly.javaCode;

/**
 * @Author konglingyao
 * @Date 2022/8/30
 */
public abstract class TestAbstract {

    public int int1=0;
    private int int2 =1;

    public void test01() {
        System.out.println("method test01 run");
        test02();

    }

    private void test02() {
        System.out.println("method test02 run");

    }
}
