package org.kly.springCode.aop.impl;



import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kly.springCode.aop.AopService;
import org.kly.springCode.aop.annotation.Validate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author konglingyao
 * @Date 2018/9/6
 */
@Service
public class AopServiceImpl implements AopService {

    private static ObjectMapper mapper = new ObjectMapper();


    static {
//        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        //该特性决定parser是否允许JSON字符串包含非引号控制字符（值小于32的ASCII字符，包含制表符和换行符）。 如果该属性关闭，则如果遇到这些字符，则会抛出异常。
    }


    public boolean complateAop() {
        String json = "{2:{\"pid\":\"2\",\"url\":\"http://item.jd.com/2.html\"}}";

        try {
            Map<String, Map<String, Object>> imap;
            imap = mapper.readValue(json, new TypeReference<Map<String, Map<String, Object>>>() {
            });
            System.out.println(imap);
            System.out.println(imap.get(2L));
            System.out.println(imap.get("2"));
        } catch (JsonParseException e) {
            System.out.println("json2Map(), 出错的json内容：" + " ,JsonParseException: " + e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println("json2Map(), 出错的json内容：" + " ,JsonMappingException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("json2Map(), 出错的json内容为：" + " ,IOException: " + e.getMessage());
        }
        System.out.println("程序运行");
        return true;
    }

    @Validate(value = "#{str}")
    @Override
    public void del(String str) {
        if (org.apache.commons.lang3.StringUtils.isBlank(str)) {
            System.out.println("null");
        }
        System.out.println(str);
    }

    private void printInt() {
        HashMap<Long, String> imap = new HashMap<>();
        imap.put(2L, "2ahmadabad");
        String asd = "2";
        System.out.println(imap.get(parseLong(asd)));

    }

    private static long parseLong(Object origin) {
        long result = 0;
        if (origin == null) {
            return result;
        }

        String s = origin.toString();

        if (!isDigit(s)) {
            return result;
        }

        try {
            result = Long.parseLong(s);
        } catch (Exception ignored) {
        }

        return result;
    }

    /**
     * 判断是纯数字
     */
    private static boolean isDigit(Object origin) {
        if (null == origin) {
            return false;
        }

        String value = origin.toString();
        if (StringUtils.isEmpty(value)) {
            return false;
        }

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c < 48 || c > 57) {
                return false;
            }
        }

        return true;
    }


}
