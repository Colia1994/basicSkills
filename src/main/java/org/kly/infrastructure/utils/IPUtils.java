package org.kly.infrastructure.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @Author konglingyao
 * @Date 2021/1/15
 */
public class IPUtils {

    private String getHostIP(){


        Enumeration<NetworkInterface> allNetInterfaces = null;
        String resultIP=null;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        InetAddress ip = null;
        while (allNetInterfaces.hasMoreElements())
        {
            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
            System.out.println(netInterface.getName());
            Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements())
            {
                ip = (InetAddress) addresses.nextElement();
                if (ip != null && ip instanceof Inet4Address)
                {
                    if(resultIP==null)
                        resultIP= ip.getHostAddress();
                    System.out.println("本机地址是："+ip.getHostAddress());

                }
            }
        }
        return resultIP;

    }


    public static void main(String[] args){
        IPUtils test1 = new IPUtils();
        test1.getHostIP();
    }
}
