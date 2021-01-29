package com.cn.webSercer.core;

import com.cn.webSercer.LoginServlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    private ServerSocket serverSocket;
    private boolean isRunning;
    public static void main(String[] args) {
        Server server = new Server();
        server.start();

    }

    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            isRunning = true;
            receive();
        } catch (IOException e) {
            System.out.println("服务器启动失败......");
        }
    }
    //封装:加入多线程
    public void receive(){
        while(isRunning) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接....");
                //多线程处理
                new Thread(new Dispatcher(client)).start();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("客户端错误");
            }
        }
    }

    //封装:加入servlet
    public void receive3(){
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客服端连接");
            //封装
            Request request = new Request(client);
            Response response =new Response(client);
            //关注了内容
            Servlet servlet = new LoginServlet();
            servlet.service(request,response);
            //关注了状态码
            response.pushToBrowser(200);

        } catch (IOException e) {
            System.out.println("客户端错误");
        }
    }
    //封装后
    public void receive1(){
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客服端连接");
            //封装
            Request request = new Request(client);

            Response response =new Response(client);
            //关注了内容
            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("服务器响应成功");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.print("shsxt server终于回来了。。。。"+request.getParameter("uname"));
            response.print("</body>");
            response.print("</html>");
            //关注了状态码
            response.pushToBrowser(200);

        } catch (IOException e) {
            System.out.println("客户端错误");
        }
    }

    @SuppressWarnings("all")
    public void receive2(){
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客服端连接");
            /*InputStream is = client.getInputStream();
            byte[] datas = new byte[1024 * 1024 * 10];
            int len = is.read(datas);
            String requestInfo = new String(datas, 0, len);
            System.out.println(requestInfo);*/

            //封装
            Request request = new Request(client);

            //关注了内容
            StringBuilder content =new StringBuilder();
            content.append("<html>");
            content.append("<head>");
            content.append("<title>");
            content.append("服务器响应成功");
            content.append("</title>");
            content.append("</head>");
            content.append("<body>");
            content.append("shsxt server终于回来了。。。。");
            content.append("</body>");
            content.append("</html>");
            int size = content.toString().getBytes().length; //必须获取字节长度
            StringBuilder responseInfo =new StringBuilder();
            String blank =" ";
            String CRLF = "\r\n";
            //返回
            //1、响应行: HTTP/1.1 200 OK
            responseInfo.append("HTTP/1.1").append(blank);
            responseInfo.append(200).append(blank);
            responseInfo.append("OK").append(CRLF);
            //2、响应头(最后一行存在空行):
			/*
			 Date:Mon,31Dec209904:25:57GMT
			Server:shsxt Server/0.0.1;charset=GBK
			Content-type:text/html
			Content-length:39725426
			 */

            responseInfo.append("Date:").append(new Date()).append(CRLF);
            responseInfo.append("Server:").append("shsxt Server/0.0.1;charset=GBK").append(CRLF);
            responseInfo.append("Content-type:text/html").append(CRLF);
            responseInfo.append("Content-length:").append(size).append(CRLF);
            responseInfo.append(CRLF);
            //3、正文
            responseInfo.append(content.toString());
            //写出到客户端
            BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(responseInfo.toString());
            bw.flush();
        } catch (IOException e) {
            System.out.println("客户端错误");
        }
    }

    //停止服务
    public void stop() {
        isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("服务器已停止");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
