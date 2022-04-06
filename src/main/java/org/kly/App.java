package org.kly;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.kly.javaCode.TestDO;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Hello world!
 */
public class App {


//    public static void main(String[] args) {
//        System.out.println(StringUtils.rightPad(String.valueOf(10), 19, "0"));
//        String test = "中文";
//        System.out.println(test.length());
//        try {
//            System.out.println(test.getBytes("gbk").length);
//
//            System.out.println(new String(test.getBytes("gbk"), "gbk"));
//
//        } catch (Exception e) {
//
//        }
//
//    }


    public static void main(String[] args) {
//        BigDecimal amt = BigDecimal.ZERO;
//
//        BigDecimal pst = new BigDecimal("216.94");
//
//        BigDecimal ist = new BigDecimal("0.1825");
//        int i = 0;
//        while (i < 20) {
//            BigDecimal bd = BigDecimal.valueOf(1.0 / 365).setScale(20, RoundingMode.HALF_UP);
//            bd = pst.multiply(ist).multiply(bd);
//            amt = amt.add(bd.setScale(4, RoundingMode.HALF_UP));
//            System.out.println(amt);
//            i++;
//
//        }
        TestDO testDO = new TestDO();
        testDO.s1 = "1";
        testDO.s2 = "2";
        System.out.println(JSON.toJSONString(testDO));

    }


}
