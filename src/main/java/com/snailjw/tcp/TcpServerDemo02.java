package com.snailjw.tcp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 服务端
 * @author : snail
 * @date : 2021-12-09 21:23
 **/
public class TcpServerDemo02 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999);
             Socket clientSocket = serverSocket.accept();
             InputStream in = clientSocket.getInputStream();
             FileOutputStream fos = new FileOutputStream("2copy.png")){
            int len ;
            byte[] buffer = new byte[1024];
            while ((len = in.read(buffer))!= -1){
                fos.write(buffer,0,len);
            }

//            告诉客户端已经读取完了
            OutputStream out = clientSocket.getOutputStream();
            out.write("我读取完了".getBytes(StandardCharsets.UTF_8));

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
