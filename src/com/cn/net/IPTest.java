package com.cn.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class IPTest {
    public static void main(String[] args) throws IOException {
        test1();
    }

    //爬虫+模拟浏览器
    public static void test1() throws IOException {
        //获取URL
        URL url = new URL("https://www.dianping.com");
        //下载资源
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.26 Safari/537.36");
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        String msg = null;
        while ((msg = br.readLine()) != null) {
            System.out.println(msg);
        }
        br.close();
    }

    //爬虫原理
    public static void test() throws IOException {
        //获取URL
        URL url = new URL("https://www.jd.com");
        //下载资源
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String msg = null;
        while ((msg = br.readLine()) != null) {
            System.out.println(msg);
        }
        //分析数据，处理数据。大数据需求
        br.close();
    }

    /**
     * URL: 统一资源定位器,互联网三大基石之一(html http),区分资源
     *  1、协议
     *  2、域名、计算机
     *  3、端口: 默认80
     *  4、请求资源
     *  http://www.baidu.com:80/index.html?uname=shsxt&age=18#a
     */

    public void urlTest () throws MalformedURLException {
        URL url = new URL("http://www.baidu.com:80/index.html?uname=shsxt&age=18#a");
        //获取四个值
        System.out.println("协议:" + url.getProtocol());
        System.out.println("域名|ip:" + url.getHost());
        System.out.println("端口:" + url.getPort());
        System.out.println("请求资源1:" + url.getFile());
        System.out.println("请求资源2:" + url.getPath());

        //参数
        System.out.println("参数:" + url.getQuery());
        //锚点
        System.out.println("锚点:" + url.getRef());

    }

    /**
     * 查看所有端口：netstat -ano
     * 查看指定端口：netstat -aon | findstr "8080"
     * 查看指定进程：tasklist|findstr "8080"
     * 查看具体程序：任务管理器详细界面PID
     */
    public static void portTest () {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost", 9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress2.getAddress());
        System.out.println(socketAddress2.getPort());
    }

    public static void ipTest () throws UnknownHostException {
        //IP:定位一个计算机节点
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

        address = InetAddress.getByName("www.baidu.com");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

        address = InetAddress.getByName("39.156.66.14");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
    }
}
