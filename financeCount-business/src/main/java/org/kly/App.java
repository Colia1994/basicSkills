package org.kly;

import org.kly.basicSkills.algorithm.leetcode.medium.m_945_使数组唯一的最小增量;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 2,2};

        Map<Integer, Integer> integerMap = new HashMap<>();

        //工具类的使用
        for (Integer i : A) {
            System.out.println("key:"+ i+",value:"+ integerMap.get(i));

            integerMap.merge(i, 1,(k ,v)-> k + 1);
            System.out.println("key:"+ i+",value:"+ integerMap.get(i));
        }
        integerMap.get(0);
    }


}
