package org.kly.designPatterns.行为型模式.中介者模式;

/**
 * @Author konglingyao
 * @Date 2020/7/7
 */
public class Ministry extends AbstractColleague{

    public Ministry(AbstractMediator abstractMediator) {
        super(abstractMediator);
    }

    public void buildPalace(){
        super.abstractMediator.dealThing(Mediator.MINISTRY_CODE);
    }

    public void selfFunction(){
        System.out.println("要建筑图纸没问题，我尽量复制多几份");
    }
}
