package com.gupaoedu.demo.aqs.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟一个等待线程
 * zengqingliang
 * 2019/6/11 21:56
 */
public class ConditionWait implements  Runnable{

    private ReentrantLock lock;
    private Condition condition;

    public ConditionWait(ReentrantLock lock, Condition condition){
        this.lock = lock;
        this.condition = condition;
    }


    @Override
    public void run() {
        lock.lock();

        try {
            System.out.println("begin-ConditionWait");
            condition.await();
            System.out.println("end-ConditionWait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
