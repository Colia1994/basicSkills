package org.kly.designPatterns.行为型模式.观察者模式;

/**
 * @Author konglingyao
 * @Date 2020/7/7
 */
public class Hero extends Subject {
    private int[] sit = new int[]{0, 0};

    void move(boolean left) {
        if (left) {
            sit[1] += 1;
        } else {
            sit[0] += 1;
        }
        System.out.println("勇者移动到坐标（" + sit[0] + "，" + sit[1] + ")");
        super.notifyObserver(sit);
    }
}
