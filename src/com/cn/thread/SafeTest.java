package com.cn.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SafeTest {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1000, "结婚礼金");
        Drawing you = new Drawing(account, 80, "可悲的你");
        Drawing wife = new Drawing(account, 90, "happy的她");
        you.start();
        wife.start();

        //测试容器
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                synchronized (list) { //锁住list，保证全部获取
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(list.size());
    }

}

//个人账户
class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//模拟取款
class Drawing extends Thread {
    Account account;
    int drawingMoney;
    int packetTotal;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        test1();
    }

    //使用同步块锁定Account,目标明确
    public synchronized void test1() {
        //提高性能，双重检测提高性能
        if (account.money <= 0) {
            return;
        }
        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                return;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            packetTotal += drawingMoney;
            System.out.println(this.getName() + "-->账号余额：" + account.money);
            System.out.println(this.getName() + "-->口袋的钱：" + packetTotal);
        }
    }

    //锁定的资源是Drawing里的this，应该锁定Account
    protected synchronized void test() {
        if (account.money - drawingMoney < 0) {
            return;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money -= drawingMoney;
        packetTotal += drawingMoney;
        System.out.println(this.getName() + "-->账号余额：" + account.money);
        System.out.println(this.getName() + "-->口袋的钱：" + packetTotal);
    }
}