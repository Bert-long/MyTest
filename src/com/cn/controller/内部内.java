package com.cn.controller;

public class 内部内 {
    public static void main(String123[] args){
        //非静态内部类
        Outer.Inner a = new Outer(). new Inner();
        a.show();
        //静态内部类
        Outer2.Inner b = new Outer2.Inner();
        b.show();
        //匿名内部内
        内部内.test(new Outer3() {
            @Override
            public void a() {
                System.out.println("出招吧！匿名内部内");
            }
        });

//        局部内部类
        new Outer4().show();
    }

    public static void test(Outer3 a){
        a.a();
    }
}

class Outer4{
    public void show(){
        class Inner{
            public void fun(){
                System.out.println("出击吧！局部内部类");
            }
        }
        new Inner().fun();
    }

}
//匿名内部内
interface Outer3{
    void a();
}
//非静态内部类
class Outer{
    private int age = 10;
    public void test(){};

    class Inner{
        int age = 20;
        public void show(){
            int age = 30;
            System.out.println(age);
            System.out.println(this.age);
            System.out.println(Outer.this.age);
        }
    }
}
//静态内部类
class Outer2{
    private int age = 10;
    public void test(){};

    static class Inner{
        int age = 20;
        public void show(){
            int age = 30;
            System.out.println(age);
            System.out.println(this.age);
//            System.out.println(Outer.this.age);
        }
    }
}
