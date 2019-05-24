package com.gupaoedu.demo.chain;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * 保存处理
 * zengqingliang
 * 2019/5/24 14:32
 */
public class SaveProcess extends Thread implements RequestProcess {

    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<Request>();

    Request requestproc = null;

    RequestProcess nextProcess = null;

    public SaveProcess(RequestProcess nextProcess){
        this.nextProcess = nextProcess;
    }

    @Override
    public void run(){
        try {
            while(!Thread.currentThread().isInterrupted()) {//
                requestproc = (Request) linkedBlockingQueue.take();
                System.out.println("SaveProcess:" + requestproc.getName());
                nextProcess.process(requestproc);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void process(Request request) {
        linkedBlockingQueue.add(request);
    }
}
