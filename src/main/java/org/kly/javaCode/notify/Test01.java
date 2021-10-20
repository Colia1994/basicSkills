package org.kly.javaCode.notify;

/**
 * @Author konglingyao
 * @Date 2021/10/20
 */
public class Test01 {

    public static final byte[] sou1 = new byte[1];

    public static void main(String[] args) {
        Thread jsThread = new Thread(() -> {
            int i = 1;
            while (i < 100) {
                synchronized (sou1) {
                    System.out.println("1我拿到锁了");
                    System.out.println(i);
                    i += 2;
                    try {
                        sou1.notifyAll();
                        sou1.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, "奇数打印");
        Thread osThread = new Thread(() -> {
            int i = 2;
            while (i < 101) {
                synchronized (sou1) {
                    System.out.println("2我拿到锁了");
                    System.out.println(i);
                    i += 2;
                    try {
                        sou1.notifyAll();
                        sou1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            }
        }, "偶数打印");
        jsThread.start();
        osThread.start();
    }
}
