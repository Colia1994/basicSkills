package org.kly.designPatterns.行为型模式.观察者模式;

/**
 * 尝试运行
 * @Author konglingyao
 * @Date 2020/7/7
 */
public class Client {

    public static void main(String[] args){
        Hero hero = new Hero();
        Monster monster = new Monster();
        hero.attachObserver(monster);
        hero.move(false);
        hero.move(true);
        hero.move(true);
    }
}
