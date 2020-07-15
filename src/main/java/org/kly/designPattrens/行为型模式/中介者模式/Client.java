package org.kly.designPattrens.行为型模式.中介者模式;

/**
 * @Author konglingyao
 * @Date 2020/7/7
 */
public class Client {
    public static void main(String[] args) {
        //尚书省出面
        AbstractMediator abstractMediator = new Mediator();
        //发生天灾了
        Department department = new Department(abstractMediator);
        department.dealDisaster();


        //要打仗了，兵部的活来了
        Defense defense = new Defense(abstractMediator);
        defense.fight();

        //皇帝发话了，工部赶紧建行宫
        Ministry ministry = new Ministry(abstractMediator);
        ministry.buildPalace();
    }
}
