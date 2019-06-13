package com.gupaoedu.demo.aqs.condition;

import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.util.resources.cldr.ka.LocaleNames_ka;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 通过两个线程分别调用Condition工具的await方法和signal方法，进行线程间的阻塞和唤醒
 * zengqingliang
 * 2019/6/11 22:03
 */
public class ConditionApp {


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new ConditionWait(lock,condition)).start();

        new Thread(new ConditionNotify(lock,condition)).start();

    }






}
