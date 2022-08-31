package org.kly.javaCode;

/**
 * @Author konglingyao
 * @Date 2022/8/30
 */
public class TestAbstractInner extends TestAbstract {

    public TestAbstractInner(){
        super();

    }

    public void test03() {
        System.out.println("method test03 run");
        test01();

    }

    public static void main(String... args){
        TestAbstractInner testAbstractInner = new TestAbstractInner();
        testAbstractInner.test03();

    }
}
