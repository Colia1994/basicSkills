package org.kly.javaCode.test;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.assertj.core.util.Lists;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author konglingyao
 * @Date 2022/3/4
 */
public class Order {

    public static void main(String[] args) {

        List<MetricDimensionTrendValue> ret = new ArrayList<>();
        ret.add(MetricDimensionTrendValue.builder()
                .aggregateValue(10d)
                .dimensionValue("100001")
                .time(1645718400000L).build());
        ret.add(MetricDimensionTrendValue.builder()
                .aggregateValue(10d)
                .dimensionValue("100002")
                .time(1645718400000L).build());
        ret.add(MetricDimensionTrendValue.builder()
                .aggregateValue(10d)
                .dimensionValue("100003")
                .time(1645718400000L).build());
        ret.add(MetricDimensionTrendValue.builder()
                .aggregateValue(10d)
                .dimensionValue("100001")
                .time(1645804800000L).build());
        ret.add(MetricDimensionTrendValue.builder()
                .aggregateValue(10d)
                .dimensionValue("100002")
                .time(1645804800000L).build());
        ret.add(MetricDimensionTrendValue.builder()
                .aggregateValue(10d)
                .dimensionValue("100003")
                .time(1645804800000L).build());
        ret.add(MetricDimensionTrendValue.builder()
                .aggregateValue(10d)
                .dimensionValue("100001")
                .time(1645891200000L).build());
        ret.add(MetricDimensionTrendValue.builder()
                .aggregateValue(10d)
                .dimensionValue("100002")
                .time(1645891200000L).build());
        ret.add(MetricDimensionTrendValue.builder()
                .aggregateValue(10d)
                .dimensionValue("100003")
                .time(1645891200000L).build());

        //维度聚合列表数据
        Map<String, List<MetricTrendValue>> resultMap = ret.stream()
                .collect(Collectors.toMap(
                        //key是维度
                        MetricDimensionTrendValue::getDimensionValue,
                        //value是当前维度的趋势数据
                        item -> Lists.newArrayList(MetricTrendValue.builder()
                                .baseTrafficGroupId(item.getBaseTrafficGroupId())
                                .time(item.getTime())
                                .value(item.getValue())
                                .trafficCount(item.getTrafficCount()).build()),
                        //聚合逻辑
                        (List<MetricTrendValue> newValueList, List<MetricTrendValue> oldValueList) -> {
//                            oldValueList.addAll(newValueList);
                            newValueList.addAll(oldValueList);
                            return newValueList;
                        }
                ));
        //维度聚合列表数据2
        Map<String, List<MetricDimensionTrendValue>> resultMap2 = ret.stream().collect(Collectors.groupingBy(MetricDimensionTrendValue::getDimensionValue));

        List<MetricTrendValue> list = resultMap.get("100003");
        List<MetricDimensionTrendValue> list2 = resultMap2.get("100003");


        LocalDate start = DateUtils.timestampToLocalDate(list.get(0).getTime());
        LocalDate end = DateUtils.timestampToLocalDate(list.get(list.size() - 1).getTime());
        int distance = Math.toIntExact(ChronoUnit.DAYS.between(start, end));
        if (distance < 1) {
            System.out.println(distance);
        }
        Map<LocalDate, MetricTrendValue> map = list.stream().collect(Collectors.toMap(i -> DateUtils.timestampToLocalDate(i.getTime()), Function.identity()));
        int size = distance + 1;
        List<MetricTrendValue> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            LocalDate curDate = start.plusDays(i);
            MetricTrendValue value = map.get(curDate);
            result.add(value == null ? MetricTrendValue.builder().time(DateUtils.localDateToTimestamp(curDate)).build() : value);
        }
        System.out.println(result);
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
