package com.gupaoedu.demo.chain;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 前置处理类
 * zengqingliang
 * 2019/5/24 14:12
 */
public class PrevProcess extends Thread implements RequestProcess {

    LinkedBlockingQueue<Request> requestLink = new LinkedBlockingQueue<Request>();

    RequestProcess nextProcess = null;

    public PrevProcess(RequestProcess nextProcess){
        this.nextProcess = nextProcess;
    }

    Request requestproc = null;

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()) {//连续不断地工厂，除非调用finalProcess，将intercept置为true停止。
                requestproc = (Request) requestLink.take();
                System.out.println("PrevProcess:" + requestproc.getName());
                nextProcess.process(requestproc);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }


    public void process(Request request) {
        requestLink.add(request);//添加进入以后就可以实现阻塞队列的同步执行，获取request对象做处理
    }
}
