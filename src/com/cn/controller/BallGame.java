package com.cn.controller;

import javax.swing.*;

public class BallGame extends JFrame {

    void launchFrame(){
        setSize(400,400);
        setLocation(400,400);
        setVisible(true);
    }

    public static void main(String[] args) {

        long d1 = System.currentTimeMillis();
        System.out.printf("%d 结果：%s%n", 10, af(10));
        long d2 = System.currentTimeMillis();
        System.out.printf("递归费时：%s%n", d2 - d1);

    }
    public static int af(int n){
        if (n == 0){
            return 1;
        } else {
            return n * af(n - 1);
        }
    }
        /*整除循环
        int i = 0;
        while (i < 1000){
            if (i%5 == 0){
                System.out.print(i + "\t");
            }
            i++;
            if (i%25 == 0){
                System.out.println();
            }
        }
        int b = 0;
        for (int a = 0; a<= 1000; a++){
            if (a%5 == 0 ){
                System.out.print(a + "\t");
                b++;
            }
            if (b == 5){
                System.out.println();
                b = 0;
            }
        }*/
//        while循环计算100以内的偶数，奇数的和
  /*      int i = 0;
        int sum1 = 0;
        int sum2 = 0;
        while (i <= 100){
            if (i%2 == 0){
                sum1 += i;
                i++;
            } else {
                sum2 += i;
                i++;
            }
        }
        System.out.println(sum1 + "+" + sum2);*/

        //窗口
//        BallGame game = new BallGame();
//        game.launchFrame();
//        int a = (int) 3.23;
//        float c = 3.14F;
//        byte b = 127;
//        System.out.println(a + b);
       /* 循环
        int b = 0;
        int q0 = 1;
        int q1 = 1;
        int q2 = 1;
        int q3 = 0;
        while (b < 6){
            int a = (int) (3*Math.random());
            b = a;
            switch (a){
                case 0:
                    System.out.println("0出现"+ q0++ +"次");
                    continue;
                case 1:
                    System.out.println("1出现"+ q1++ +"次");
                    continue;
                case 2:
                    System.out.println("2出现"+ q2++ +"次");
                    if (q2 == 7){
                        b = 6;
                    }
                    continue;
            }

        }
        System.out.println(q0+q1+q3);*/
//  乘法表
      /* for(int i = 1; i<10; i++){
           for (int j = 1; j<= i; j++){
               System.out.print( i + "*" + j + "=" + i*j + "\t");
           }
           System.out.println();
       }*/





}
