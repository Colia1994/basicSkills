package org.kly.javaCode.test;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * @Author konglingyao
 * @Date 2020/7/26
 */
@Controller
@RequestMapping("/api/test")
public class TestController {


    @GetMapping("/parse1")
    public Map parse1() {
        TestResource process = (TestResource) ApplicationContextUtils.getBean("student");

        System.out.println(JSON.toJSONString(process));
//        parseBatchXMLService.executeJob(path);
//        JobViewDTO jobViewDTO = new JobViewDTO();
        return null;
    }

    public static void main(String... args){
        A testa = new A();
        A testn = testa.cons(2);

        System.out.println(testa instanceof A);
        System.out.println(testn instanceof A);
        Class innerClazz[] = A.class.getDeclaredClasses();
        Class b = null;
        for (Class c : innerClazz) {
            int mod = c.getModifiers();
            //返回整数编码对应的修饰符的字符串对象
            String modifier = Modifier.toString(mod);
            //找到被private修饰的内部类
            if (modifier.contains("private")) {
                b = c;
            }
        }
        System.out.println(testn.getClass() ==  b);

    }


}
