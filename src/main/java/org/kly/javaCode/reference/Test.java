package org.kly.javaCode.reference;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author konglingyao
 * @Date 2022/8/22
 */
public class Test {

    public static void main(String[] args) {

        Integer i1 = new Integer(1999);
        final List<String> l1 = new ArrayList<>();
        Integer i2 = i1;

        i2 += 1;

        System.out.println(i1 + "---------" + i2);


    }
}
