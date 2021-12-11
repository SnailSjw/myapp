package com.snailjw.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * UDP发送/接收消息
 * @author : snail
 * @date : 2021-12-09 22:24
 **/
public class UdpClientDemo01 {
    private static final int PORT = 9999;
    private static final String HOST ="127.0.0.1";
    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try(DatagramSocket socket = new DatagramSocket()){
                String msg = buffer.readLine();

                byte[] m = msg.getBytes(StandardCharsets.UTF_8);
                InetAddress address = InetAddress.getByName(HOST);
                DatagramPacket datagramPacket = new DatagramPacket(m,0,m.length,address,PORT);
                socket.send(datagramPacket);
                if (msg.equalsIgnoreCase("bye")){
                    break;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
