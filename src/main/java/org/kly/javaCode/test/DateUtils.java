package org.kly.javaCode.test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @Author konglingyao
 * @Date 2022/3/4
 */
public class DateUtils {

    public static LocalDate timestampToLocalDate(Long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Long localDateToTimestamp(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
