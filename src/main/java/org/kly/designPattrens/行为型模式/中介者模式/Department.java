package org.kly.designPattrens.行为型模式.中介者模式;

/**
 * @Author konglingyao
 * @Date 2020/7/7
 */
public class Department extends AbstractColleague{

    public Department(AbstractMediator 	abstractMediator) {
        super(abstractMediator);
    }

    public void dealDisaster(){
        super.abstractMediator.dealThing(Mediator.DEPARTMENT_CODE);
    }

    public void selfFunction(){
        System.out.println("打钱，给粮食！");
    }
}
