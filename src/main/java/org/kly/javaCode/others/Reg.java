package org.kly.javaCode.others;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author konglingyao
 * @Date 2022/10/9
 */
public class Reg {

    public static void main(String[] args) {
       String str = "<p>文本1<br/><a href= \"https://www.baidu.com\\\" target=\\\"\\\">https://www.baidu.com</a> 文本2<br/>文本3</p>";

       System.out.println(str.replaceAll("<[^a][^>]+>",""));

//        new Uint8Array("");



    }
}
