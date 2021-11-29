package com.snailjw.socket.bio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio Socket的Service
 *
 * @author : snail
 * @date : 2021-11-29 09:13
 **/
public class Service {
    private static final int port = 8888;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while (true){
                Socket socket = server.accept();
                new Thread(new ServiceHandler(socket)).start();
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("inetAddress = " + inetAddress);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            // 创建服务端socket
//            ServerSocket serverSocket = new ServerSocket(8088);
//
//            // 创建客户端socket
//            Socket socket = new Socket();
//
//            //循环监听等待客户端的连接
//            while(true){
//                // 监听客户端
//                socket = serverSocket.accept();
//
//                ServerThread thread = new ServerThread(socket);
//                thread.start();
//
//                InetAddress address=socket.getInetAddress();
//                System.out.println("当前客户端的IP："+address.getHostAddress());
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
    }
}
