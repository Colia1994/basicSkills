package org.kly.designPatterns.行为型模式.中介者模式;

/**
 * @Author konglingyao
 * @Date 2020/7/7
 */
public class Defense extends AbstractColleague{

    public Defense(AbstractMediator abstractMediator) {
        super(abstractMediator);
    }

    public void fight(){
        super.abstractMediator.dealThing(Mediator.MINISTRY_CODE);
    }

    public void selfFunction(){
        System.out.println("兄弟们上");
    }
}
