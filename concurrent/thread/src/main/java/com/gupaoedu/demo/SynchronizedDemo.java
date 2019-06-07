package com.gupaoedu.demo;

import java.io.IOException;

/**
 *
 * 使用Synchronized锁住对象，使多个线程顺序执行
 * zengqingliang
 * 2019/5/25 15:10
 */
public class SynchronizedDemo {
    static String a = "";
    static Integer count=0;

    public static void incr(){
        synchronized (a) {
            try {

                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(()->SynchronizedDemo.incr()).start();
        }
        Thread.sleep(5000);
        System.out.println("result:"+count);
    }

}
