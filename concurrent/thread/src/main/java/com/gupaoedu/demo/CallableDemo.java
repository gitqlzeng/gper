package com.gupaoedu.demo;

import java.util.concurrent.*;

/**
 * 通过线程池实现线程方法执行后获取结果
 * ExecutorService
 * zengqingliang
 * 2019/5/24 13:28
 */
public class CallableDemo implements Callable {

    public static void main(String[] args) throws InterruptedException,ExecutionException{
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future future = executorService.submit(new CallableDemo());
        System.out.println(future.get());
        executorService.shutdown();

    }

    public Object call() throws Exception {
        return 1+1;
    }
}
