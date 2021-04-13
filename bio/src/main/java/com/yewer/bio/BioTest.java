package com.yewer.bio;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class BioTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);

//        最简模式
//        Socket socket = serverSocket.accept();
//        byte[] receiveBuffer = new byte[128];
//        int receiveBytes =socket.getInputStream().read(receiveBuffer);
//        if (receiveBytes!=-1){
//            System.out.println(new String(receiveBuffer,0,receiveBytes));
//        }
        // 线程模式
        while (true) {
            //主线程循环接受连接
            Socket socket = serverSocket.accept();
            //每个连接启动一个新线程循环接受数据
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        byte[] receiveBuffer = new byte[128];
                        int receiveBytes = 0;
                        try {
                            receiveBytes = socket.getInputStream().read(receiveBuffer);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (receiveBytes != -1) {
                            System.out.println(new String(receiveBuffer, 0, receiveBytes));
                        }
                    }
                }
            }).start();
            //注意不能用run()
        }
        
    }
   
}
