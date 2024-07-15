package org.kly.javaCode.test;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @Author konglingyao
 * @Date 2022/3/4
 */
public class Order {

    public static void main(String[] args) {
        Double i = 0.79898d;
        System.out.println(i.longValue());
        System.out.println(i);
        System.out.println(String.valueOf(i));
    }

    @Data
    @SuperBuilder
    public static class MetricTrendValue {

        private Long baseTrafficGroupId;
        private Long time;
        private Double value;
        private Double lastWeekValue;
        private Double yesterdayValue;
        private Double trafficRatio;
        private Double trafficCount;

    }

    @Data
    @SuperBuilder
    public static class MetricDimensionTrendValue extends MetricTrendValue {

        /**
         * 维度：如活动的具体某个活动ID
         */
        private String dimensionValue;

        /**
         * 指标值：本次查询的这个维度的具体指标值
         */
        private Double aggregateValue;
    }


}
