package com.gupaoedu.demo.distributed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket服务器端
 * zengqingliang
 * 2019/5/31 11:03
 */
public class SocketServerDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readline = bufferedReader.readLine();
        System.out.println(readline);
      /*  while(!"bye".equals(readline)) {
            readline = bufferedReader.readLine();
            System.out.println(readline);
        }*/
        socket.close();
        serverSocket.close();
    }

}
