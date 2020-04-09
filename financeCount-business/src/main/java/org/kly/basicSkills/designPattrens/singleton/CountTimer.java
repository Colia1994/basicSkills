package org.kly.basicSkills.designPattrens.singleton;

/**
 * 计时计数类
 *
 * @author colia
 * @date 2017-07-20
 */
class CountTimer {

    private static CountTimer countTimer;

    //私有构造函数
    private CountTimer() {

    }

    /**
     * 饿汉式加载，线程不安全
     */
    static CountTimer getCountTimer() {
        if (null == countTimer) {
            countTimer = new CountTimer();
        }
        return countTimer;
    }

    /**
     * 饿汉式加载，线程不安全 （Double Check Locking 双检查锁机制）
     */
    static CountTimer getCountTimerSynchronized() {
        if (null == countTimer) {
            //TODO
            //同步代码块 (只包住可能会导致多个实例产生的代码)
            synchronized (CountTimer.class) {
                if (null == countTimer) { //二次检查
                    countTimer = new CountTimer();
                }
            }
        }
        return countTimer;
    }

    /**
     * 静态内部类
     */
    static CountTimer getCountTimerInnner() {
        return InnerCountTimer.countTimer1;
    }

    private static class InnerCountTimer {
        public final static CountTimer countTimer1 = new CountTimer();
    }
}