package org.kly.javaCode.functional;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author konglingyao
 * @Date 2020/7/23
 */
public class Test {

    private int x = 10;

    // 使用自定义的函数式接口作为方法参数
    private static void doSomething(MyFunctionalInterface inter) {
        inter.doSomething(); // 调用自定义的函数式接口方法
    }

    private static void doPredicate(Predicate<String> predicate, String str) {

        System.out.println(predicate.test(str));
    }

    private void test01(int x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
//        doSomething(() -> System.out.println("doing"));
//        doSomething(System.out::println);
//        doPredicate(s -> s.length() > 5, "xxxxxxxx");
//        Test test = new Test();
//        test.test01(20);
//
//        List<Long> test01 = new ArrayList<>();
//
//        test01.stream().collect(Collectors.toMap(p-> p, p -> false));

        List<Double> metricTrendValues = new ArrayList<>();
        metricTrendValues.add(null);
        metricTrendValues.add(null);
        metricTrendValues.add(null);
        //统计分组后的总指标值
        DoubleSummaryStatistics collect = metricTrendValues.stream().filter(Objects::nonNull)
                .collect(Collectors.summarizingDouble(value -> value));
        System.out.println(collect.getSum());
    }


}
