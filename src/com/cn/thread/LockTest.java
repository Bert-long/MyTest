package com.cn.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    Lock lock = new Lock();
    ReLock reLock = new ReLock();

    public static void main(String[] args) throws InterruptedException {
        //ReentrantLock
        ReentrantLock lock = new ReentrantLock();
        //不可重入锁
        LockTest lockTest = new LockTest();
//        lockTest.a();
//        lockTest.doA();

        //可重入锁
        lockTest.b();
        Thread.sleep(1000);
        System.out.println(lockTest.reLock.getCount());

    }

    public void a() throws InterruptedException {
        lock.lock();
        doA();
    }

    public void doA() throws InterruptedException {
        lock.lock();
        lock.unlock();
    }

    public void b() throws InterruptedException {
        reLock.lock();
        System.out.println(reLock.getCount());
        doB();
        reLock.unlock();
        System.out.println(reLock.getCount());
    }

    public void doB() throws InterruptedException {
        reLock.lock();
        System.out.println(reLock.getCount());
        reLock.unlock();
        System.out.println(reLock.getCount());
    }


}

//不可重入锁
class Lock {
    private boolean isLocked = false; //是否占用

    //使用锁
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    //释放锁
    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}

//可重入锁
class ReLock {
    private boolean isLocked = false; //是否占用
    private Thread lockedBy = null;           //储存线程
    private int count = 0;

    public int getCount() {
        return count;
    }

    //使用锁
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (isLocked && lockedBy != t) {
            wait();
        }
        isLocked = true;
        lockedBy = t;
        count++;
    }

    //释放锁
    public synchronized void unlock() {
        if (Thread.currentThread() == lockedBy) {
            count--;
            if (count == 0) {
                isLocked = false;
                notify();
                lockedBy = null;
            }
        }
    }
}