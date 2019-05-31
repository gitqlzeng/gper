package com.gupaoedu.demo.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock应用demo
 * zengqingliang
 * 2019/5/27 12:20
 */
public class reentrantLockDemo {
    static ReentrantLock reentrantLock = new ReentrantLock();
    static int count = 0;
    public static void main(String[] args) throws InterruptedException{
        for(int i = 0;i<100;i++) {
            new Thread(() -> {

                reentrantLock.lock();//增加ReentrantLock保证count++在多线程中的同步运行++，保证正确性
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                reentrantLock.unlock();
            }).start();
        }
        Thread.sleep(2000);//休眠2s等待for循环的100次，和thread中的sleep 5；
        System.out.println(count);
    }
}
