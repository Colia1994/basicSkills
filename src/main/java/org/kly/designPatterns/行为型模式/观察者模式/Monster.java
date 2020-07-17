package org.kly.designPatterns.行为型模式.观察者模式;

/**
 * @Author konglingyao
 * @Date 2020/7/7
 */
public class Monster implements Observer {

    //怪物坐标
    private final int[] sit = new int[]{1, 2};
    //攻击范围
    private final int length = 1;

    @Override
    public void update(int[] xy) {
        if(inRange(xy)){
            System.out.println("怪物攻击你");
        }
    }

    private boolean inRange(int[] xy) {
       return (Math.abs(sit[0] - xy[0]) + Math.abs(sit[1] - xy[1])) <= length;
    }
}
