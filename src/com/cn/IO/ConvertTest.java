package com.cn.IO;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ConvertTest {
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        OutputStreamWriter os = new OutputStreamWriter(System.out);
        //改进:以字符流来操作字节流
        /*try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));) {
            String a = "";
            while (!a.equals("exit")){
                a = reader.readLine();
                writer.write(a);
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        test3();


    }

    public static void test3(){
        //InputStreamReader操作网络流
        try (BufferedReader is =
                     new BufferedReader(
                             new InputStreamReader(
                                     new URL("http://www.baidi.com").openStream(),"UTF-8"));
             BufferedWriter os =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream("baidu.html"),"UTF-8"));){
            String msg;
            while ((msg = is.readLine()) != null){
                os.write(msg); //乱码原因：字符集不统一
                os.newLine();
                os.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void test2(){
        //InputStreamReader操作网络流
        try (BufferedReader is =
             new BufferedReader(
                new InputStreamReader(
                    new URL("http://www.baidi.com").openStream(),"UTF-8"))){
            String msg;
            while ((msg = is.readLine()) != null){
                System.out.println(msg);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void test1(){
        //InputStreamReader操作网络流
        try (InputStreamReader is =
                new InputStreamReader(
                    new URL("http://www.baidi.com").openStream(),"UTF-8");){
            int temp;
            while ((temp = is.read()) != -1){
                System.out.print((char) temp);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void test(){
        //InputStream操作网络流
        try (InputStream inputStream = new URL("http://www.baidi.com").openStream()){
            int temp;
            while ((temp = inputStream.read()) != -1){
                System.out.print((char) temp); //字节数不够出现乱码
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
