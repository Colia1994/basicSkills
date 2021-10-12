package org.kly.javaCode.optional;

import lombok.Data;

import java.time.LocalDate;

/**
 * @Author konglingyao
 * @Date 2021/10/12
 */
@Data
public class Order {

    private long id;

    private Goods goods;

    private LocalDate time;



}
