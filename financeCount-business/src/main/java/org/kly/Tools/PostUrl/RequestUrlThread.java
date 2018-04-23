package org.kly.Tools.PostUrl;

import java.util.Date;
import java.util.Random;

/**
 * 线程开启，随机睡眠，每10次更换新的ip
 * @author colia
 * @date 2017-08-08
 */
class RequestUrlThread extends Thread {

    private String url;
    private String param;
    private Integer currentNum = 0;
    RequestUrlThread(String url, String param){
        this.url = url;
        this.param = param;
    }

    public void run(){
        for(int j = 1; j > 0; j++) {
            String ip = VotePostByIp.randomIpAddr("china");
            for (int i = 0; i < 10; i++) {
                try {
                    long seed = System.currentTimeMillis();
                    Random random = new Random(seed);
                    //间隔随机秒数
                    sleep(1000 * (random.nextInt(10) + 1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String sr = VotePostByIp.sendGetToUrl(url, param, ip);
                System.out.println(sr);
                currentNum++;
                System.out.println("当前线程投票数为："+currentNum+"---当前系统时间："+new Date(System.currentTimeMillis()));
            }
            try {
                long seed = System.currentTimeMillis();
                Random random = new Random(seed);
                //间隔随机秒数
                sleep(10000 * (random.nextInt(10)+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
