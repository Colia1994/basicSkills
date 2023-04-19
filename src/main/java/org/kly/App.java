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




        String s1 = "i love {name} and {n1}";

        String[] s2 =  s1.split("i");

        System.out.println(s2[0]);


    }



}
