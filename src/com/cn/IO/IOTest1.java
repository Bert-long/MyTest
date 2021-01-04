package com.cn.IO;

import java.io.*;

public class IOTest1 {
    public static void main(String[] args) throws IOException {
        //创建源
        File file = new File("src/images/123.txt");
        write(file);

        String path = "src/images/五十音图.jpg";
        String path1 = "src/images/五十音图.jpg";
        byte[] data = fileToByteArray(path);
        System.out.println(data.length);
        byteArrayToFile(path1, data);
    }

    //图片读取到字节数组
    public static byte[] fileToByteArray(String path) {
        File file = new File(path);
        byte[] dest = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        InputStream pag = null;
        try {
            pag = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len=pag.read(flush)) != -1) {
                byteArrayOutputStream.write(flush,0,len);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (pag != null) {
                    pag.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    //字节数组写出到图片
    public static void byteArrayToFile(String path, byte[] bytes) {

    }

    //一个个读取
    public static void read1(File file) {
        InputStream is = null;
        try {
            //选择流
            is = new FileInputStream(file);
            //操作，读取
            int temp;
            while ((temp = is.read()) != -1) {
                System.out.println((char) temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //多个字节一起读取
    public static void read2(File file) throws IOException {
        InputStream is = null;
        try {
            //选择流
            is = new FileInputStream(file);
            //操作，读取
            byte[] flush = new byte[1024 * 2];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                String s = new String(flush, 0, len);
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    //写数据
    public static void write(File file) throws IOException {
        OutputStream os = null;
        try {
            //选择流
            os = new FileOutputStream(file, true);//true是接着写，false是删除后写
            //操作，写
            String msg = "LSP";
            byte[] data = msg.getBytes();//字符串转化为字节码
            os.write(data, 0, data.length);
            os.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
}
