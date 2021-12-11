package com.snailjw.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 客户端向服务端发送文件数据
 * @author : snail
 * @date : 2021-12-09 21:13
 **/
public class TcpClientDemo02 {
    private static final int port= 9999;
    private static final String host = "127.0.0.1";
    public static void main(String[] args) {
        try (Socket socket = new Socket(host,port);
             OutputStream out = socket.getOutputStream();
             FileInputStream fis = new FileInputStream((("D:\\user\\Pictures\\2.png")))){
            int len ;
            byte[] buffer = new byte[1024];
            while ((len= fis.read(buffer))!= -1){
                out.write(buffer,0,len);
            }
            socket.shutdownOutput(); //注意这句，如果不写客户端和服务器都结束不了。

//            确认服务器接收完毕后再断开
            len = 0;
            buffer = new byte[1024];
            try(InputStream inputStream = socket.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();){
                while ((len = inputStream.read(buffer)) != -1){
                    baos.write(buffer,0,len);
                }
                System.out.println(baos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
