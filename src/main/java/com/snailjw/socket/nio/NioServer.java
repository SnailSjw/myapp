package com.snailjw.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * NIO 服务端
 *
 * @author : snail
 * @date : 2021-11-29 12:17
 **/
public class NioServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.bind(new InetSocketAddress(8888));
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            System.out.println("等待事件发生");
            selector.select();
            System.out.println("有事件发生了");
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                handle(key);
            }
        }
    }

    public static void handle(SelectionKey key) throws IOException {
        if (key.isAcceptable()){
            System.out.println("连接事件发生");
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            //创建客户端侧的channel
            SocketChannel channel = serverSocketChannel.accept();
            channel.configureBlocking(false);
            channel.register(key.selector(),SelectionKey.OP_READ);
        }else if (key.isReadable()){
            System.out.println("数据可读事件发生");
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int len = channel.read(byteBuffer);
            if (len != -1){
                System.out.println("读取到客户端数据是：" + new String(byteBuffer.array(),0,len));
            }
            //给客户端发送消息
            ByteBuffer wrap = ByteBuffer.wrap("Hello Wrold".getBytes(StandardCharsets.UTF_8));
            channel.write(wrap);
            key.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);
            channel.close();
        }
    }
}
