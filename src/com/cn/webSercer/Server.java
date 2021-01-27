package com.cn.webSercer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server server = new Server();
        server.start();

    }

    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            receive();
        } catch (IOException e) {
            System.out.println("服务器启动失败......");
        }
    }
    //封装后
    public void receive(){
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

    public void receive1(){
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

    public void stop(){

    }
}
