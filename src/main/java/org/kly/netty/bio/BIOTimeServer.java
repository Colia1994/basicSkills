package org.kly.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author konglingyao
 * @Date 2023/4/18
 */
public class BIOTimeServer {

    //服务端 监听8080端口请求 如果第一行是 GET CURRENT TIME 则返回系统时间 否则 返回 BAD_REQUEST
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("TimeServer Started on 8080...");
            while (true) {
                Socket client = serverSocket.accept();
                //每次接收到一个新的客户端连接，启动一个新的线程来处理
                new Thread(new BIOTimeServerHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != serverSocket) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}


