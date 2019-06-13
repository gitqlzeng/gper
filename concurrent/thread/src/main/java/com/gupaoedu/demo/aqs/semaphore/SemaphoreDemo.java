package com.gupaoedu.demo.aqs.semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * 使用SemaphoreDemo模拟进行车位限流的Demo
 * 共享锁
 *
 * KYLE
 * 2019/6/13 22:28
 */
public class SemaphoreDemo {

    static class Car implements Runnable{
        private int num;
        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();//获取一个车位
                System.out.println("车编号："+num+" 已停好车");
                semaphore.release();//释放一个车位
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//定义3个车位
        //定义100辆车进行停车
        for(int i=0;i<100;i++){
            new Thread(new Car(i,semaphore)).start();
        }

    }



}
