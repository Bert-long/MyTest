package com.cn.list;

import java.util.*;
import java.util.ArrayList;

public class IteratorTest {
    public static void main(String[] args) {
        testIteratorMap();
    }

    public static void testIteratorList(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        for (Iterator<String> iter = list.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("c");
        set.add("d");
        for (Iterator<String> iter = set.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

    public static void testIteratorMap(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "y");
        map.put(3, "d");
        map.put(4, "h");
        //第一种遍历方法
        Set<Map.Entry<Integer, String>> s = map.entrySet();
        for (Iterator<Map.Entry<Integer, String>> iter = s.iterator(); iter.hasNext();){
            Map.Entry<Integer, String> temp = iter.next();
            System.out.println(temp.getKey() +"--"+ temp.getValue());
        }

        //第二种遍历方法
        Set<Integer> keySet = map.keySet();
        for (Iterator<Integer> iter = keySet.iterator(); iter.hasNext();){
            Integer key = iter.next();
            System.out.println(key +"--"+ map.get(key));
        }
    }

}
