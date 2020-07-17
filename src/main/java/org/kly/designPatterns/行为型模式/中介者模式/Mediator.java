package org.kly.designPatterns.行为型模式.中介者模式;

/**
 * @Author konglingyao
 * @Date 2020/7/7
 */
public class Mediator extends AbstractMediator {

    //户部处理天灾 方案
    public static final int DEPARTMENT_CODE = 1;
    //兵部打仗 方案
    public static final int DEFENSE_CODE = 2;
    //工部建行宫 方案
    public static final int MINISTRY_CODE = 3;

    //尚书省根据某一个部门提过来的协调需求 通知后续部门
    @Override
    public void dealThing(int code) {
        switch (code) {
            case DEPARTMENT_CODE:
                this.dealDisaster();
                break;
            case DEFENSE_CODE:
                this.fight();
                break;
            case MINISTRY_CODE:
                this.buildPalace();
                break;
        }
    }

    //户部处理天灾 方案
    private void dealDisaster() {
        System.out.println("户部：准备粮食钱款赈灾");
        //通知工部设计房屋
        super.ministry.selfFunction();
        //通知兵部出兵镇压
        super.defense.selfFunction();
    }

    //兵部打仗 方案
    private void fight() {
        System.out.println("兵部：准备士兵");
        //通知户部出钱出粮食 兵马未动粮草先行
        super.department.selfFunction();
    }

    //工部建行宫 方案
    private void buildPalace() {
        System.out.println("工部：准备图纸，施工方案");
        //通知户部出钱
        super.department.selfFunction();
        //通知兵部出人
        super.defense.selfFunction();
    }
}