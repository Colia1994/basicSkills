package org.kly.javaCode;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Author konglingyao
 * @Date 2020/7/23
 */
public class InnerClass {


    private String s = "outs";
    public String s1 = "outs1";
    public void test(){
            System.out.println(s);
    }
    public class InnerClass1{

//        private String s = "ins";
        public String s1 = "ins1";

        public void run(){
            System.out.println(s);
        }
    }

    public static void main(String[] args){
        InnerClass innerClass = new InnerClass();
        InnerClass.InnerClass1 innerClass1 = innerClass.new InnerClass1();
        System.out.println(innerClass.s);
        System.out.println(innerClass.s1);
        innerClass.test();
        System.out.println(innerClass.s);
        System.out.println(innerClass1.s1);
        innerClass1.run();
    }



}
