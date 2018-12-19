package org.kly.basicSkills.Concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * 题目：猴子偷桃 n个猴子去一筐桃子里偷桃，猴子很贪心，一次偷两个，不够两个时会生气的返回 请用代码模拟这个场景
 * 假设有21个桃子 2只猴子
 * @Author Colia
 * @Date 2018-4-23.
 */
public class MonkeyStealsPeach {

    private static Integer numOfPeach = 21;

    private List<String> monkeys = Arrays.asList("姜晨","大刀切鸭梨");

    private final byte[] bytes = new byte[0];

    private void stealPeach(String monkeyName){
        if(numOfPeach>2) {
            // 锁非制定对象，随意建一个数据来加锁，
            // 新建byte[0]是因为相比较与new objects() 零长度的byte数组对象创建起来将比任何对象都经济――
            // 查看编译后的字节码：生成零长度的byte[]对象只需3条操作码，而Object lock = new Object()则需要7行操作码。
            synchronized (bytes) {
                System.out.println(monkeyName + "开始偷桃子,此时桃子还剩" + numOfPeach + "个");
                if (numOfPeach > 2) {
                    numOfPeach = numOfPeach - 2;
                    System.out.println(monkeyName + "偷完了,此时桃子还剩" + numOfPeach + "个");
                } else {
                    System.out.println(monkeyName + "生气的跑了,此时桃子还剩" + numOfPeach + "个");
                }
            }
            try{
                //每一次偷桃子拿走需要耗费200ms
                Thread.sleep(200);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            if(numOfPeach >2) {
                stealPeach(monkeyName);
            }
        }else {
            System.out.println(monkeyName + "生气的跑了,此时桃子还剩" + numOfPeach + "个");
        }
    }


    public static void main (String[] args){
        final MonkeyStealsPeach monkeyStealsPeach = new MonkeyStealsPeach();

        for (final String monkeyName : monkeyStealsPeach.monkeys) {
            Thread thread = new Thread(() -> monkeyStealsPeach.stealPeach(monkeyName));
            thread.start();
        }

    }



}
