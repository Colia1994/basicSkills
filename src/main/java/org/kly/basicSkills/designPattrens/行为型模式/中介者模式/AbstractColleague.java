package org.kly.basicSkills.designPattrens.行为型模式.中介者模式;

/**
 * @Author konglingyao
 * @Date 2020/7/7
 */
public abstract class AbstractColleague {
    protected AbstractMediator abstractMediator;

    public AbstractColleague(AbstractMediator abstractMediator) {
        this.abstractMediator = abstractMediator;
    }
}
