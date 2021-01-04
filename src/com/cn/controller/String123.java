package com.cn.controller;

public class String123 {
    public static void main(String[] args){
        String a = "aaa";
        String b = a.substring(0, 1);
        System.out.println(a);
        System.out.println(b);
//       StringBuilder线程不安全效率高，StringBuffer线程安全效率低
        StringBuilder c = new StringBuilder();
        StringBuffer d = new StringBuffer();
        for (int i =0; i<26; i++){
            char t = (char)('a' + i);
            c.append(t);
        }
//       可变字符序列的常用方法
        System.out.println(c);
        c.reverse();
        System.out.println(c);
        c.setCharAt(3,'高');
        System.out.println(c);
        c.insert(0, '我').insert(2, '爱').insert(3, '钱');
        System.out.println(c);
        c.delete(20, 23);
        System.out.println(c);

//        字符串使用陷阱
        String str = "";
        long n1 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
        long t1 = System.currentTimeMillis(); //获取当前系统时间
        for (int i=0; i<5000; i++){
            str += i; //相当于产生10000个对象
        }
        long n2 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
        long t2 = System.currentTimeMillis(); //获取当前系统时间
        System.out.println("String占用内存：" + (n1-n2));
        System.out.println("String占用时间：" + (t2-t1));

        StringBuilder sb = new StringBuilder("");
        long n3 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
        long t3 = System.currentTimeMillis(); //获取当前系统时间
        for (int i=0; i<5000; i++){
            sb.append(i);
        }
        long n4 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
        long t4 = System.currentTimeMillis(); //获取当前系统时间
        System.out.println("StringBuilder占用内存：" + (n3-n4));
        System.out.println("StringBuilder占用时间：" + (t4-t3));
    }
}
