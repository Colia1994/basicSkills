package org.kly.basicSkills.designPattrens.singleton;

/**
 * 单例调试
 *
 * @author colia
 * @date 2017-07-20
 */
public class MainDebug extends Thread {

    public static void main(String[] args) {


        MainDebug[] mts = new MainDebug[10];
        for (int i = 0; i < mts.length; i++) {
            mts[i] = new MainDebug();
        }

        for (MainDebug mt : mts) {
            mt.start();
        }

    }

    @Override
    public void run() {
        //线程不安全的饿汉式
//        System.out.println(CountTimer.getCountTimer().hashCode());
        //线程安全的饿汉式
        System.out.println(CountTimer.getCountTimerSynchronized().hashCode());
    }
}