package org.kly.javaCode.classCreater;

/**
 * @Author konglingyao
 * @Date 2020/7/23
 */
public class HelloWorldAnonymousClasses {

    /**
     * 包含两个方法的HelloWorld接口
     */
    interface HelloWorld {
        void greet();

        void greetSomeone(String someone);
    }

    public void sayHello() {

        // 1、局部类EnglishGreeting实现了HelloWorld接口
        class EnglishGreeting implements HelloWorld {
            String name = "world";

            public void greet() {
                greetSomeone("world");
            }

            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        // 2、匿名类实现HelloWorld接口
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";

            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);

            }
        };
        // 3、匿名类实现HelloWorld接口
        HelloWorld spanishGreeting = new HelloWorld() {

            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }

        };

        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        frenchGreeting.greet();
        spanishGreeting.greet();
    }


    public static void main(String... args) {
        HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }
}
