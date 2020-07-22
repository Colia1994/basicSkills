package org.kly;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        String a ="abc";
        String b = new String("abc");
        System.out.println(a== b);
        System.out.println(a.equals(b));
        int a1 =1;
        Integer b1 = new Integer(1);
        System.out.println(a1== b1);
        System.out.println(b1.equals(a1));

        Map<Integer,Integer> imap = new ConcurrentHashMap<>();
    }



}
