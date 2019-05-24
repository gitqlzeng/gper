package com.gupaoedu.demo.chain;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * zengqingliang
 * 2019/5/24 14:43
 */
public class FinishProcess extends Thread implements  RequestProcess{

    LinkedBlockingQueue<Request> requestLink = new LinkedBlockingQueue<Request>();

    Request requestproc = new Request();

    @Override
    public void run(){
        try{
            requestproc = (Request)requestLink.take();
            Thread.currentThread().interrupt();
            System.out.println("FinishProcess:"+requestproc.getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public void process(Request request) {
        requestLink.add(request);
    }
}
