package org.kly.javaCode;

import com.alibaba.fastjson.JSON;
import org.springframework.cglib.beans.BeanMap;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author konglingyao
 * @Date 2021/3/19
 */
public class Common {

    public static void main(String... args) {
        TreeMap<Date, Set<Character>> treeMap1 = new TreeMap<>();
        TreeMap<Date, Set<Character>> treeMap2 = new TreeMap<>();


        Set<Character> set1 = new HashSet<>();
        set1.add('B');
        set1.add('C');
        Set<Character> set2 = new HashSet<>();
        set2.add('B');
        set2.add('C');
        treeMap1.put(new Date(),set1);
        treeMap2.put(new Date(),set2);
        treeMap1.putAll(treeMap2);

        System.out.println(set1.equals(set2));
        System.out.println(treeMap1.firstEntry().getValue().equals(treeMap2.firstEntry().getValue()));

        TreeMap<Date, TestEnum> treeMap3 = new TreeMap<>();
        TreeMap<Date, TestEnum> treeMap4 = new TreeMap<>();
        treeMap3.put(new Date(),TestEnum.Y);
        treeMap4.put(new Date(),TestEnum.N);

        System.out.println(JSON.toJSONString(treeMap3));
        System.out.println(treeMap3.firstEntry().getValue().equals(treeMap4.firstEntry().getValue()));

        BigDecimal a1 = new BigDecimal("0");
        BigDecimal a2 = new BigDecimal("0.00");

        System.out.println(a1.equals(a2));
        System.out.println(a1.compareTo(a2) == 0);



    }

    public static Map<String, List<String>> getDiff(Object expected, Object actual, String[] verifyPropertyList) {
        Map<String, List<String>> diff = new HashMap<>();
        BeanMap expectedMap = BeanMap.create(expected);
        BeanMap actualMap = BeanMap.create(actual);
        for (String verifyProperty : verifyPropertyList) {

            Object expectedValue = expectedMap.get(verifyProperty);
            Object actualValue = actualMap.get(verifyProperty);
            if (actualValue != null && expectedValue != null) {
                if (!actualValue.equals(expectedValue)) {

                }
            }
        }
        if (diff.size() == 0) {
            return null;
        } else {
            return diff;
        }
    }
}
