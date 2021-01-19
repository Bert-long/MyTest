package com.cn.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:比较并交换
 */
public class CAS {
    private static AtomicInteger stock = new AtomicInteger(5); //库存

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer a = stock.decrementAndGet();
                if (a < 1){
                    System.out.println("抢完了");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "-->" + "抢了一件商品,还剩" + a);
//                System.out.print("还剩" + a);
            }).start();
        }
    }
}
