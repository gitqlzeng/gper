package com.gupaoedu.demo.cprinciple;

/**
 *
 * 测试被volatile修饰的数组，在线程中改变元素值之后，在另一个元素中是否被修改
 * 结果：得到的结果是：
 *          thread 1:1
 *          thread 1:2
 *          thread 1:3
 *          thread 2:0
 *          thread 1:4
 *          thread 1:5
 *          thread 1:0
 *          thread 1.:0
 *
 *          说明：数组内的元素的修改，对两个线程是可见
 * zengqingliang
 * 2019/5/26 18:26
 */
public class VolatileArrayDemo {

    private static volatile String[] arrays = {"1","2","3","4","5","6"};
    public static void main(String[] args){
        new Thread(()->{
            for(int i=0;i<arrays.length;i++){
                System.out.println("thread 1:"+arrays[i]);
            }
            System.out.println("thread 1.:"+arrays[5]);
        }).start();

        new Thread(()->{
            arrays[5] = "0";
            System.out.println("thread 2:"+arrays[5]);
        }).start();
    }

}
