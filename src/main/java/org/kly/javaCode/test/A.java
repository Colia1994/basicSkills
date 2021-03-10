package org.kly.javaCode.test;

/**
 * @Author konglingyao
 * @Date 2021/3/10
 */
public class A {

    public String a;

    public A cons(int a) {
        return a == 1 ? new A() : new B();
    }

    private class B extends A {

        public String b;

    }
}
