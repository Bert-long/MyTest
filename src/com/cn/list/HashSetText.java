package com.cn.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashSetText {
    //Set主要没有顺序，不可以重复
    //List主要有顺序，可以重复
    public static void main(String[] args){
        Set<String> a = new HashSet<>();
        a.add("aa");
        a.add("bb");
        a.add("aa");

        a.iterator();
        System.out.println(a);

        HashSetText set = new HashSetText();
        set.add("set");
        System.out.println(set);
    }

    HashMap map;
    private static final Object PRESENT = new Object();
    public HashSetText(){
        map = new HashMap();
    }

    public void add(Object o){
        map.put(o, PRESENT);
    }

    public int size(){
        return map.size();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (Object key:map.keySet()){
            s.append(key + ",");
        }
        s.setCharAt(s.length()-1, ']');
        return s.toString();
    }
}
