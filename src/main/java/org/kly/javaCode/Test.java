package org.kly.javaCode;

/**
 * @Author konglingyao
 * @Date 2023/1/5
 */
public class Test {

    public static void main(String[] args) {
        //匿名内部类
        Food food = new Food(){
            //z这是 饼干
            @Override
            public void eat() {
                System.out.println("被吃了");
            }
        };
        food.eat();

        Food food1 = new Org();
        food1.eat();

    }

}

class Org implements Food{

    @Override
    public void eat() {
        System.out.println("橘子被吃了");

    }



}
