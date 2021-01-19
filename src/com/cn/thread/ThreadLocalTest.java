package com.cn.thread;


public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal3 = new ThreadLocal<>();
    //初始化值
    private static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>(){
        protected Integer initialValue(){
            return 200;
        }
    };
    //使用lambda
    private static ThreadLocal<Integer> threadLocal1 = ThreadLocal.withInitial(() ->{
        return 200;
    });
    //简化一下
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() ->200);
    //InheritableThreadLocal:会继承上下文数据，拷贝一份给子线程
    private static ThreadLocal<Integer> thread = new InheritableThreadLocal<>();

    public static void main(String[] args) {

//        setTest();
        //ThreadLocal的资源不受其他线程影响
//        for (int i = 0; i < 5; i++) {
//            new Thread(new MyRun1()).start();
//        }
        //构造器线程名字问题，Thread.currentThread()哪里调用就是那里
        //构造器哪里调用就是那里的，run方法是i新纳粹本身的
//        new Thread(new MyRun3(),"构造器").start();
        //InheritableThreadLocal测试：会继承上下文数据，拷贝一份给子线程
        thread.set(200);
        System.out.println(Thread.currentThread().getName() + "-1->主线程的" + thread.get());
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "-1->" + thread.get());
            thread.set(4);
            System.out.println(Thread.currentThread().getName() + "-1->" + thread.get());
        }).start();
        //对比threadLocal3
        threadLocal3.set(200);
        System.out.println(Thread.currentThread().getName() + "-3->主线程的" + threadLocal3.get());
        new Thread(()->{
            //这里为null，没有继承之前的值
            System.out.println(Thread.currentThread().getName() + "-3->" + threadLocal3.get());
            threadLocal3.set(4);
            System.out.println(Thread.currentThread().getName() + "-3->" + threadLocal3.get());
        }).start();
    }

    public static void setTest(){
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        threadLocal.set(99);
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        new Thread(new MyRun(),"Runnable名字").start();
    }

    public static class MyRun implements Runnable{
        @Override
        public void run() {
            threadLocal.set((int) (Math.random()*99));
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }
    }
    public static class MyRun1 implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
            threadLocal.set(threadLocal.get()/2);
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }
    }
    public static class MyRun3 implements Runnable{
        //注意线程名字，分析上下文
        //构造器线程名字问题，Thread.currentThread()哪里调用就是那里
        //构造器哪里调用就是那里的，run方法是i新纳粹本身的
        public MyRun3() {
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
            threadLocal.set(threadLocal.get()/2);
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }
    }

}



