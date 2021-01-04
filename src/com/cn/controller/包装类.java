package com.cn.controller;

public class 包装类 {
    public static void main(String[] args){
//       基本数据类型转为包装类
        Integer a = 3;
        Integer b = Integer.valueOf(30);
//        包装类转为基本数据
        int c = b.intValue();

        java.lang.String l = "aaa";


        System.out.println(l + Season.SPRING);
    }
}

enum Season{
    SPRING,SUMMER,AUTUMN,WINTER
}