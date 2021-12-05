package com.snailjw.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * NIO 客户端
 *
 * @author : snail
 * @date : 2021-11-29 12:42
 **/
public class NioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",8888));
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        //轮询访问selector
        while (true) {

        }

    }
}
