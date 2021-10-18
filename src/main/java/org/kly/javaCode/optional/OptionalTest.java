package org.kly.javaCode.optional;

import java.util.Optional;

/**
 * @Author konglingyao
 * @Date 2021/10/12
 */
public class OptionalTest {

    public static Order getOrder1(){
        //doSomething
        return null;
    }


//    public static Optional<Order> getOrder2(){
//        //doSomething
//        return Optional.empty();
//    }
    public static void main(String[] args) {

        System.out.print(OptionalTest.getOrder1().getGoods().getDescPicture().getUrl());

//        System.out.print(OptionalTest.getOrder2().map(Order::getGoods).map(Goods::getDescPicture).map(Picture::getUrl).orElse("null")); ;
    }

//    public  Order getOrder2(){
//        //doSomething
//        return null;
//    }
    public Order getOrder2(OptionalTest this){
        //doSomething
        return null;
    }
}
