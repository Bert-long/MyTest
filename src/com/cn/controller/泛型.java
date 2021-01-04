package com.cn.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class 泛型  {
    public static void main(String[] args){

        MyCollection<String> m = new MyCollection<>();

        m.set("龙",0);
        m.set("k",1);
        System.out.println(m.get(0));

        Collection<String> c = new ArrayList<>();
        System.out.println(c.size());
        System.out.println(c.isEmpty());

        c.add("韩");
        c.add("韩1");
        System.out.println(c.size());
        System.out.println(c);

        System.out.println(c.toArray());
        c.remove("韩");
        System.out.println(c);

    }

}

class MyCollection<E>{
    Object[] ob = new Object[5];

    public void set(E o, int index){
        ob[index] = o;
    }

    public E get(int index){
        return (E)ob[index];
    }

}