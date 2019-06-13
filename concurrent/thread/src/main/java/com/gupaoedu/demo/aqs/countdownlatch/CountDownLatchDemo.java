package com.gupaoedu.demo.aqs.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 *
 * 线程间的计数器，利用CountDownLatch工具的await用于等待其他线程结束计数后执行其后面的方法
 * KYLE
 * 2019/6/13 22:18
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {

        CountDownLatch cdl = new CountDownLatch(3);

        new Thread(()->{
            System.out.println("已处理完1个!");
            cdl.countDown();
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("已处理完1个！");
            cdl.countDown();
        }).start();

        new Thread(()->{
            System.out.println("已处理完1个");
            cdl.countDown();
        }).start();

        try {
            cdl.await();
            System.out.println("全部处理完，进行后面的处理");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
