package org.kly.javaCode;

import net.minidev.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author konglingyao
 * @Date 2023/1/5
 */
public class Test {

    public static void main(String[] args) {
        String arg = "[YyMmDdHhSs]+|[^YyMmDdHhSs]";

        String test01 = "YYYY-MM:DD hh:mm:ss.S";
        Pattern pattern = Pattern.compile(arg);
        Matcher matcher = pattern.matcher(test01);

        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        for (String str : list) {
            if (str.matches("[YyMmDdHhSs]+")) {
                //这是年 月日 时分秒的map函数
                System.out.println("map函数---"+str);
            }else {
                //占位符处理逻辑
                System.out.println("占位符---" + str);
            }
        }

    }

}

