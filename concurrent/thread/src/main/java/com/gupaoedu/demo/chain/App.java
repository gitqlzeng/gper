package com.gupaoedu.demo.chain;

/**
 *
 * 入口
 *
 * zengqingliang
 * 2019/5/24 14:10
 */
public class App {



    public static void main(String[] args) {
        Request request = new Request();
        request.setName("kyle");

        FinishProcess finishProcess = new FinishProcess();
        finishProcess.start();
        SaveProcess saveProcess = new SaveProcess(finishProcess);
        saveProcess.start();
        PrevProcess prevProcess = new PrevProcess(saveProcess);
        prevProcess.start();

        prevProcess.process(request);

    }
}
