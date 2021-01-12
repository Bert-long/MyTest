package com.cn.thread;

import javax.swing.plaf.nimbus.State;

//yield礼让线程，暂停线程，进入就绪状态，不是阻塞状态
//join:合并线程，插队
//stop:线程正常结束或加入判断让线程结束，不推荐使用stop方法
//新生状态：new Throw
//进入就绪状态：1：start运行进入。2：阻塞后进入。3：yield结束后进入。4：JVM进入
//进入阻塞状态：1：sleep 2:join 3:wait 4:IO操作read,write
//结束状态：正常结束
public class ThreadTest {
    boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
//        stopTest();
//        join();
//        yield01();
//        state();

        //查看优先级：默认优先级NORM_PRIORITY = 5，MAX_PRIORITY 10 ,MIN_PRIORITY = 1; 设置优先级在启动前，表示概率
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().isAlive();  //线程是否活着，currentThread获取当前运行的线程对象
        System.out.println(Thread.currentThread().getName()); //获取当前线程名字
        Thread.currentThread().setName("大宝");              //设置线程名字
        System.out.println(Thread.currentThread().getName());
    }

    //查看线程状态
    public static void state(){
        Thread thread = new Thread(()->{
            System.out.println("...");
        });

        System.out.println(thread.getState()); //新生状态：NEW
        thread.start();
        System.out.println(thread.getState()); //运行状态：RUNNABLE
        //守护线程：是为用户线程服务的；默认的线程都是用户线程。JVM需要等待用户线程停止，不需要等待守护线程停止
        thread.setDaemon(true); //设置守护线程


    }

    public static void yield01(){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("小宝" + i);
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            //yield：在10的倍数时候，重新竞争cpu资源
            if (i%10 == 0){
                Thread.yield();
            }
            System.out.println("主线程" + i);
        }
    }

    public static void join() throws InterruptedException {

        Thread thread = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("小宝" + i);
            }
        });
        thread.start();

        for (int i = 0; i < 100; i++) {
            //到20的时候，join线程抢先执行
            if (i == 20){
                thread.join();
            }
            System.out.println("主线程" + i);
        }
    }

    public static void stopTest(){
        new Thread(()->{
            boolean flag = true;
            int i = 0;
            while (flag){
                if (i == 20){
                    flag = false;
                }
                System.out.println("测试" + (i++));
            }
        }).start();
    }

    public static void stop(boolean flag){
        flag = false;
    }
}
