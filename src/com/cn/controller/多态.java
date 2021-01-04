package com.cn.controller;

public class 多态 {
    public static void main(String123[] args){
        Animal a = new Animal();
        A(a);
        A(new Cat());
        String A = "nis";
    }

    static void A(Animal a){
        a.shout();
    }
}

class Animal{
    public void shout(){
        System.out.printf("叫");
    }
}

class Cat extends Animal{
    @Override
    public void shout(){
        System.out.printf("喵");
    }
}

class Dog extends Animal{
    @Override
    public void shout(){
        System.out.printf("汪");
    }
}