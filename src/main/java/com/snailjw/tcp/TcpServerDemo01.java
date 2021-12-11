package com.snailjw.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * @author : snail
 * @date : 2021-12-09 20:35
 **/
public class TcpServerDemo01 {
    public static void main(String[] args) throws IOException {
        try{
            try (ServerSocket serverSocket = new ServerSocket(9999);
                 Socket client = serverSocket.accept();
                 InputStream in = client.getInputStream();
                 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
            ){
                byte[] buffer = new byte[1024];
                int len ;
                while ( (len = in.read(buffer)) != -1){
                    byteArrayOutputStream.write(buffer,0,len);
                }
                System.out.println(byteArrayOutputStream);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
