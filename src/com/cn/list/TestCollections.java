package com.cn.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        for (int i=0; i<10;i++){
            a.add("l"+ i);
        }
        System.out.println(a);
        //随机排序
        Collections.shuffle(a);
        System.out.println(a);
        //逆序排序
        Collections.reverse(a);
        System.out.println(a);
        //递增排序，Comparable接口
        Collections.sort(a);
        System.out.println(a);
        //二分法查找
        System.out.println(Collections.binarySearch(a, "l2"));



    }
}
