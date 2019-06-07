package com.gupaoedu.demo.distributed;

import java.io.*;
import java.net.Socket;

/**
 * socket客户端
 * zengqingliang
 * 2019/5/31 11:04
 */
public class SocketDemo {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8080);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String readline = "";
//        while(!"bye".equals(readline)) {
            readline = bufferedReader.readLine();
            printWriter.print(readline);
            printWriter.flush();
//        }
        bufferedReader.close();
        printWriter.close();
    }
}
