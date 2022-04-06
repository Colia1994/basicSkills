package org.kly.javaCode;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author konglingyao
 * @Date 2022/4/6
 */
@Component
@Scope("prototype")
public class TestDO {

    public String s1;
    public String s2;


    public String getTest(){
        return "sTest";
    }

    public boolean isXXTest(){
        return true;
    }

}
