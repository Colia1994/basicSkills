package org.kly.Tools.PostUrl;



import org.kly.Utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

/**
 * 服务器锁定ip情况下模拟请求，发送get post请求
 *
 * 需求提出者，老爹。投票
 * @author colia
 * @date 2017-08-08
 */
public class VotePostByIp {
    public static void main( String[] args ) {
        voteForMyFather();
    }

    /**
     * 投票
     */
    private static void voteForMyFather() {
        String url = "http://zxb.525j.com.cn/activity/api/votehandler.ashx";
        String prams = "type=voting&foremanid=58";
        new RequestUrlThread(url,prams).start();
    }

    /**
     * 构建get请求
     * @param url 地址
     * @param param 参数
     * @param ip ip
     * @return 服务器响应参数
     */
    static String sendGetToUrl(String url, String param, String ip) {
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        String result = "";
        try {
            URL realUrl = new URL(url+"?"+param);
            //构建模拟请求
            URLConnection urlConnection = realUrl.openConnection();
            //制定发送ip
            if(!StringUtils.isBlack(ip)) {
                urlConnection.setRequestProperty("X-Forwarded-For", ip);
                urlConnection.setRequestProperty("HTTP_X_FORWARDED_FOR", ip);
                urlConnection.setRequestProperty("HTTP_CLIENT_IP", ip);
                urlConnection.setRequestProperty("REMOTE_ADDR", ip);
            }
            //通用请求头
            urlConnection.setRequestProperty("Connection", "keep-alive");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");

            //建立连接
            urlConnection.connect();
            //输入流读取url响应信息
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            //获取服务器响应信息
            result = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 构建post请求
     * @param url 地址
     * @param param  参数
     * @param ip ip
     * @return 服务器返回结果
     */
    public String sendPostToUrl(String url, String param,String ip) {
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            //构建模拟请求
            URLConnection urlConnection = realUrl.openConnection();
            //制定发送ip
            if(!StringUtils.isBlack(ip)) {
                urlConnection.setRequestProperty("X-Forwarded-For", ip);
                urlConnection.setRequestProperty("HTTP_X_FORWARDED_FOR", ip);
                urlConnection.setRequestProperty("HTTP_CLIENT_IP", ip);
                urlConnection.setRequestProperty("REMOTE_ADDR", ip);
            }
            //通用请求头
            urlConnection.setRequestProperty("Connection", "keep-alive");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
            //判断请求方式
            urlConnection.setRequestProperty("Content-Length", "17");
            urlConnection.setRequestProperty("Origin", "ORIGIN");
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlConnection.setRequestProperty("Referer", "REFERER");
            urlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            urlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,pt;q=0.2");
            //post请求必须要设置这两个值
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);

            //获取输出流
            printWriter = new PrintWriter(urlConnection.getOutputStream());
            //发送请求参数
            printWriter.print(param);
            //输出流缓冲
            printWriter.flush();
            //输入流读取url响应信息
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            //获取服务器响应信息
            result = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (printWriter != null) {
                    printWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     *  生成一个随机ip
     * @return ip
     */
    static String randomIpAddr(String code) {
        //设定一个种子，确保多线程每一次生成的ip组合序列一定不相同
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        int ip1,ip2,ip3,ip4;
        if(!"china".equals(code)) {
            ip1 = random.nextInt(255) + 1;//左闭右开
            ip2 = random.nextInt(256);
            ip3 = random.nextInt(256);
            ip4 = random.nextInt(256);
        }else{
            //58 比较接近中国ip
            ip1 = 58;//左闭右开
            ip2 = 200 + random.nextInt(56);
            ip3 = random.nextInt(256);
            ip4 = random.nextInt(256);
        }
        return ip1 + "." + ip2 + "." + ip3 + "." + ip4;
    }


}
