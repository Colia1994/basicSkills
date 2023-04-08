package org.kly.javaCode.others;

import java.util.Map;
import java.util.HashMap;

/**
 * @Author konglingyao
 * @Date 2022/10/9
 */
public class Reg {

    public static void main(String[] args) {
        String str = "{womenName} love {menName}";

        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("womenName", "zhanghui");
        jsonMap.put("menName", "konglingyao");
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            str = str.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        System.out.println(str);


    }


}
