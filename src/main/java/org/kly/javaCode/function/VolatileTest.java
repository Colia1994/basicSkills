package org.kly.javaCode.function;

/**
 * @Author konglingyao
 * @Date 2021/10/8
 */
public class VolatileTest {

    private volatile boolean flag = true;

    public void refresh() {
        flag = Boolean.FALSE;
        System.out.println("flag  false");
    }


    public void load() {
        int i=0;
        while (flag){
            i++;
            System.out.println("循环"+i);

        }
        System.out.println("跳出了循环");
    }

    public static void main(String... args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        new Thread(volatileTest::load,"thread1").start();
        Thread.sleep(2000);
        new Thread(volatileTest::refresh,"thread2").start();
    }

}
