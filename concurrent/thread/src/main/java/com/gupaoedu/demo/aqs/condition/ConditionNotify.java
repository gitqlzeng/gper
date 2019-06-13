package com.gupaoedu.demo.aqs.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟一个唤醒线程
 * zengqingliang
 * 2019/6/11 21:59
 */
public class ConditionNotify implements Runnable{

    private ReentrantLock lock;
    private Condition condition;

    public ConditionNotify(ReentrantLock lock, Condition condition){
        this.lock = lock;
        this.condition = condition;
    }


    @Override
    public void run() {
        lock.lock();
        System.out.println("begin-ConditionNotify");
        condition.signal();
        System.out.println("end-ConditionNotify");
        lock.unlock();
    }
}
