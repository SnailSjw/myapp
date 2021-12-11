package com.snailjw.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author : snail
 * @date : 2021-12-09 22:43
 **/
public class UdpServerDemo01 {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(9999)){
            while (true){
                //            接收数据包
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
                socket.receive(packet);
                System.out.println("datagramPacket.getAddress() = " + packet.getAddress());
                final String receiveDate = new String(packet.getData(), 0, packet.getLength());
                System.out.println("datagramPacket.getData() = " + receiveDate);
                if (receiveDate.equals("bye")){
                    break;
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
