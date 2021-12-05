package com.snailjw.socket.bio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * bio 处理Service
 *
 * @author : snail
 * @date : 2021-11-29 09:14
 **/
public class ServiceHandler implements Runnable{
    private Socket socket;

    public ServiceHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
//        BufferedReader in = null;
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = null;
        try {
//            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String body = null;
            while(true){
                body = scanner.nextLine();
                if(body == null) {
                    break;
                }
                System.out.println("Server :" + body);
                out.println(body);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
