package com.cn.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args){
        List list1 = new ArrayList();
        list1.add("a");
        list1.add("b");
        list1.add("c");

        list1.add(2,"f");
        System.out.println(list1);
    }

    public static void test2(){
        List list1 = new ArrayList();
        list1.add("a");
        list1.add("b");
        list1.add("c");

        list1.add(2,"f");
        System.out.println(list1);
        list1.remove(2);
        System.out.println(list1);
        list1.set(2, "lll");
        System.out.println(list1.get(2));
        list1.add("g");
        list1.add("k");
        System.out.println(list1);
        System.out.println(list1.indexOf("g"));
    }

    public static void test1(){
        List list1 = new ArrayList();
        list1.add("a");
        list1.add("b");
        list1.add("c");

        List list2 = new ArrayList();
        list2.add("a");
        list2.add("d");
        list2.add("e");

        System.out.println(list1);
//      并集，把相同部分去掉，交集
//        list1.addAll(list2);
//        list1.removeAll(list2);
        list1.retainAll(list2);
        System.out.println(list1);
//  是否包含
        System.out.println(list1.containsAll(list2));
    }
}
