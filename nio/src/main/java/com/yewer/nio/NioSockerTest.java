package com.yewer.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioSockerTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("0.0.0.0",8888),50);
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while(true){
            selector.select();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeySet.iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                if(!next.isValid()){
                    continue;
                }

                if(next.isAcceptable()){
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) next.channel();
                    SocketChannel clientChannel = serverSocketChannel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector,SelectionKey.OP_READ);
                }

                if(next.isReadable()){
                    ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[1024]);
                    SocketChannel clientChannel = (SocketChannel) next.channel();
                    int read = clientChannel.read(byteBuffer);

                    if(read==-1){
                        next.cancel();
                        clientChannel.close();
                    } else {
                        System.out.println(byteBuffer);
                        byteBuffer.flip();
                        clientChannel.write(byteBuffer);
                    }
                }
            }
            it.remove();
        }
    }
}
