package org.kly;

import com.alibaba.fastjson.JSON;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.apache.commons.lang3.StringUtils;
import org.kly.javaCode.TestDO;
import org.kly.javaCode.TestEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        List<String> strList = new ArrayList<>();
        strList.add("test");
        strList.add("test01");
        strList.add("test02");
        strList.add("test03");
        strList.add("test04");
        System.out.println(Thread.currentThread().getName() + ":测试开始");

//        strList.stream().parallel().forEach(App::printLog);
//        strList.parallelStream().forEach(App::printLog);
        strList.forEach(string -> {
                   Runnable run = () -> App.printLog(string);
                   System.out.println(Thread.currentThread());
                   run.run();
                }
        );


        System.out.println(Thread.currentThread().getName() + ":测试结束");

    }

    public static void printLog(String str) {
        if (str.equals("test04")) {
            System.out.println(Thread.currentThread().getName() + "error" + str);
            throw new RuntimeException();
        }

        System.out.println(Thread.currentThread().getName() + str);

    }


}
