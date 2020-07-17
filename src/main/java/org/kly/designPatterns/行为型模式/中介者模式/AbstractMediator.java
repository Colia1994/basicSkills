package org.kly.designPatterns.行为型模式.中介者模式;

/**
 * @Author konglingyao
 * @Date 2020/7/7
 */
public abstract class AbstractMediator {

    protected Department department;
    protected Defense defense;
    protected Ministry ministry;

    public AbstractMediator() {
        department = new Department(this);
        defense = new Defense(this);
        ministry = new Ministry(this);
    }

    //中介者最重要的方法叫做事件方法，处理多个对象之间的关系
    public abstract void dealThing(int code);
}
