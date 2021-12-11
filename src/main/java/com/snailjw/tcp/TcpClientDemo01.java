package com.snailjw.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 狂神说：网络编程demo1-客户端发送一次数据到服务端
 * 客户端类
 * @author : snail
 * @date : 2021-12-09 20:19
 **/
public class TcpClientDemo01 {
    public static void main(String[] args) {
        int port = 9999;
        try{
            InetAddress serverIP = InetAddress.getLocalHost();
            Socket client = new Socket(serverIP,port);
            try(OutputStream out = client.getOutputStream();){
                out.write("这是客户端发送的信息".getBytes(StandardCharsets.UTF_8));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
