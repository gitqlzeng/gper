package com.gupaoedu.demo.cprinciple;

import static java.lang.Thread.sleep;

/**
 * 线程间的对象lock，wait、notify
 * zengqingliang
 * 2019/5/25 18:47
 */
public class ThreadWaitAndNotifyDemo {
    public static void main(String[] args) {
        String lock = "";//锁对象

        //创建两个线程，模拟线程间的通行，a对线程进行阻塞，b对线程进行唤醒
        Thread a = new Thread(()-> {
                synchronized (lock){
                    try {
                        System.out.println("a:我阻塞了");
                        lock.wait();
                        System.out.println("a:我被唤醒了");

                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
        });
        Thread b = new Thread(() -> {
            synchronized (lock){
                lock.notify();//要用同一个锁对象进行唤醒
                System.out.println("b:通知唤醒~");
            }
        });

        a.start();
        //wait后等待2秒再被唤醒
        try { sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        b.start();

    }
}
