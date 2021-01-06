package com.cn.IO;

import java.io.*;

public class FileUtils {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = new FileInputStream("src/images/五十音图.jpg");
        OutputStream os = new FileOutputStream("src/images/acd.jpg");
        copy(is,os);
    }

    public static void copy(InputStream is, OutputStream os){
        try(is;os) {
            byte[] flush = new byte[1024];
            int length;
            while ((length=is.read(flush)) != -1){
                os.write(flush,0,length);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close(is,os);
            close1(is,os);
        }
    }

    public static void close(InputStream is, OutputStream os){
        try {
            if (is != null){
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (os != null){
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close1(Closeable... ios){
        for(Closeable io:ios){
            if (io != null){
                try {
                    io.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
