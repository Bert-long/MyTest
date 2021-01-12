package com.cn.thread;

/**
 *
 *
 */
public class Lambda {
    public static void main(String[] args) {
        Interests k = (a, b) ->{
            System.out.println(a + "-" + b);
            int i = a + b;
            return i;
        };
        System.out.println(k.lambda(100, 200));

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                System.out.println("学习时间：" + i);
            }
        }).start();
        new Thread(()-> System.out.println("简化学习中")).start();
    }
}

interface Interests{
    int lambda(int a, int b);
}



