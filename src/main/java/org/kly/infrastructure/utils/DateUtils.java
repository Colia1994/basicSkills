package org.kly.infrastructure.utils;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Author konglingyao
 * @Date 2023/2/14
 */
public class DateUtils {

    public static long getDiffOfDay(Long startTime, Long endTime) {
        LocalDate start = timestampToLocalDate(startTime);
        LocalDate end = timestampToLocalDate(endTime);
        return ChronoUnit.DAYS.between(start, end);
    }

    public static long getDiffOfMinute(Long startTime, Long endTime) {
        LocalDateTime start = timestampToLocalDateTime(startTime);

        LocalDateTime end = timestampToLocalDateTime(endTime);
        Duration duration = Duration.between(start, end);
        return duration.toMinutes();
    }

    public static LocalDate timestampToLocalDate(Long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public static LocalDateTime timestampToLocalDateTime(Long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.getDiffOfMinute(1676368981000L, 1676368976000L));
    }
}
