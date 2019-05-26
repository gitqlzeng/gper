package com.gupaoedu.demo.cprinciple;

/**
 * volatile实现变量在线程间的可见性。会在线程读写之前加入内存屏障，使线程对变量的操作是互相可见的
 *
 * zengqingliang
 * 2019/5/26 13:54
 */
public class VolatileDemo {
    private static/* volatile */boolean offOn = false;
    /*调试过程中发现以下问题：
    Integer换成int会对offOn存在可见性问题，offOn没有读到true，while循环不会结束。
    但如果把count定义成Integer类型，就会结束，此时offOn并没有被volatile修饰，也实现了可见。猜测原因：
                                                难道是因为线程去堆里面读写count的时候，顺便就读过来的吗？
    Mic老师给的答复：
        为什么同样在jdk1.8之下，有些能跳出，有些不能跳出。 取决于当前运行的jvm是server模式还是client模式。
        如果是server模式，那么如果没有增加volatile，就不会去检查offon这个值，因此只做++操作。
        如果增加了volatile，会去检查offOn这个值。
     */
    private static Integer count = 0;
    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new Thread(()->{
            while (!offOn){
                count++;
            }
            System.out.println(count);
        });
        thread1.start();

        //让thread1里面的count ++ 2s
        Thread.sleep(2000);

        /*offOn使用volatile修饰后，线程thread1在下次读offOn的时候
            由于内存屏障StoreLoad，需要从主内存中读取刚写入的最新值true。
         */
        offOn = true;
    }
}
