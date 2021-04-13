package com.yewer.lockandsynchronized;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        SynchronizedTest synTest = new SynchronizedTest();
        SynchronizedTest synTest2 = new SynchronizedTest();

        new Thread(new Runnable() {
            public void run() {
                synTest.test02();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                synTest.test02();
            }
        }).start();

        // 创建3个线程对象
        LockTest lockTest = new LockTest();

        Thread t1 = new Thread(lockTest, "窗口1");
        Thread t2 = new Thread(lockTest, "窗口2");
        Thread t3 = new Thread(lockTest, "窗口3");

        // 启动线程
        // t1.start();
        // t2.start();
        // t3.start();

        synchronized(synTest){
            while(true){
              Scanner sc = new Scanner(System.in);
             System.out.println(sc.next());
             synTest.notify();
             synTest.wait();
            }
        }
  




    }
}