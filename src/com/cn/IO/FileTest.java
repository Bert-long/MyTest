package com.cn.IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FileTest {
    public static void main(String[] args) throws IOException {
        String path = "src/images/五十音图.jpg";
        File file = new File(path);

        //基本信息
        System.out.println("名称："+ file.getName());
        System.out.println("路径："+ file.getPath());
        System.out.println("绝对路径："+ file.getAbsolutePath());
        System.out.println("父路径："+ file.getParent());
        System.out.println("父对象："+ file.getParentFile().getName());
        //基本判断
        System.out.println("是否存在："+ file.exists());
        System.out.println("是否文件："+ file.isFile());
        System.out.println("是否文件夹："+ file.isDirectory());
        System.out.println("长度："+ file.length());

        //创建文件删除文件
        File f = new File("src/images/123.txt");
        boolean flag = f.createNewFile();
        System.out.println("创建文件"+flag);
        boolean flag1 = f.delete();
        System.out.println("删除文件"+flag1);

        //创建目录，list获取下级名称，listFile获取下级文件名
        //mkdir，上级目录必须存在。mkdirs，可以不存在(多使用)
        File f1 = new File("src/images/test/1");
        boolean flag2 = f1.mkdir();
        System.out.println("mkdir创建目录是否成功"+ flag2);
        boolean flag3 = f1.mkdirs();
        System.out.println("mkdirs创建目录是否成功"+ flag3);
        File f2 = new File("src/images");
        String[] strings = f2.list();
        for (String a:strings){
            System.out.println("List:"+ a);
        }
        File[] strings1 = f2.listFiles();
        for (File a:strings1){
            System.out.println("listFiles:"+ a.getAbsolutePath());
        }
        printName(f2,0);
    }
    //打印目录下所有文件和文件夹名称
    public static void printName(File file, int deep){
        for (int i=0; i<deep; i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (!file.exists()){
            return;
        }else if(file.isDirectory()){
            for (File a:file.listFiles()){
                printName(a, deep+1);
            }
        }
    }
}
