package org.kly;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println(StringUtils.rightPad(String.valueOf(10), 19, "0"));
        String test = "中文";
        System.out.println(test.length());
        try {
            System.out.println(test.getBytes("gbk").length);

            System.out.println(new String(test.getBytes("gbk"), "gbk"));

        } catch (Exception e) {

        }

    }


}
