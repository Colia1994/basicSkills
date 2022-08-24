package org.kly;

import com.alibaba.fastjson.JSON;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.apache.commons.lang3.StringUtils;
import org.kly.javaCode.TestDO;
import org.kly.javaCode.TestEnum;

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

        switch (TestEnum.N){
            case N:
                System.out.println("N");
                break;

            case Y:
                System.out.println("Y");
                break;

        }
//        DefaultContext<String,Object> context = new DefaultContext<>();
//        context.put("d","{\"0\":\"A,B\",\"1\":\"D,C\"}");
//        ExpressRunner runner = new ExpressRunner();
//        String jsonRule = "{\"0\":\"C\",\"1\":\"D\"}";
//
//        String express = String.format("JSONAntMatch(d,'%s')", jsonRule);
//        System.out.println(express);
//
//        try {
//            Object result = runner.execute(express,context,null,false,false);
//            System.out.println(result);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }


}
