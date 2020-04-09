package org.kly.basicSkills.classCreater;

/**
 * 从结果中可以看到，在创建一个B类的实例时，执行的详细步骤如下：
 * <p>
 * 进入构造函数
 * 为成员变量分配内存
 * 执行父类中静态成员变量和静态初始化块相关的操作
 * 执行子类中静态成员变量和静态初始化块相关的操作
 * 执行父类中非静态成员变量和非静态初始化块中的相关操作
 * 执行父类构造函数体中的操作（总是会调用父类构造函数，隐式super()或显示调用。父类构造函数的调用必须是构造器中的第一个语句。）
 * 执行子类中非静态成员变量和非静态初始化块中的相关操作
 * 执行子类构造函数主体中的操作
 *
 * @Author konglingyao
 * @Date 2018/12/17
 */
public class Creater {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.declareAndSet);
    }

}

class A {
    {
        System.out.println("A: non-static initialization block 1");
    }

    private static int a1 = a1();

    private static int a1() {
        System.out.println("A: static int a1 = a1()");
        return 0;
    }


    private int a2 = a2();

    private int a2() {
        System.out.println("A: int a2 = a2()");
        return 0;
    }

    {
        System.out.println("A: non-static initialization block 2");
    }

    A() {
        System.out.println("A: A().");
        init();
    }

    public void init() {
        System.out.println("A: inti()");
    }

    static {
        System.out.println("A: static initialization block 1");
    }
}

class B extends A {
    private static int b1 = b1();

    private static int b1() {
        System.out.println("B: static int b1 = b1()");
        return 0;
    }

    private int b2 = b2();

    private int b2() {
        System.out.println("B: int b2 = b2()");
        return 0;
    }

    {
        System.out.println("B: non-static initialization block 2");
    }

    String declareAndSet = "value in declared.";

    B() {
        System.out.println("B: B()");
        //init(); 这里测试赋值与初始化的不同含义感兴趣可以自行放开注释对比结果的差异
    }

    @Override
    public void init() {
        System.out.println("B: inti()");
        declareAndSet = "value in init()";
    }

    static {
        System.out.println("B: static initialization block 1");
    }
}