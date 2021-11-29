package com.snailjw.socket.bio;

import java.io.*;
import java.net.Socket;

/**
 * Socket的Client
 *
 * @author : snail
 * @date : 2021-11-29 09:03
 **/
public class Client {
    private static final String address = "127.0.0.1";
    private static final int port = 8888;

    public static void main(String[] args) {
        try {
            // 和服务器创建连接
            Socket socket = new Socket(address,port);

            // 要发送给服务器的信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("客户端发送信息");
            pw.flush();

            socket.shutdownOutput();

            // 从服务器接收的信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info = br.readLine())!=null){
                System.out.println("我是客户端，服务器返回信息："+info);
            }

            br.close();
            is.close();
            os.close();
            pw.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
