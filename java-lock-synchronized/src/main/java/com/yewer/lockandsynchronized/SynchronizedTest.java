package com.yewer.lockandsynchronized;



//synchronized不是可中断锁，Lock是可中断锁 
//synchronized是非公平锁，它无法保证等待的线程获取锁的顺序。

public class SynchronizedTest {

    String str = new String("lock");
     int i=10;

    // 修饰在方法上，多个线程调用同一个对象的同步方法会阻塞，
    // 调用不同对象的同步方法不会阻塞。 （java对象的内存地址是否相同）
    public synchronized void test01() {
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                // Thread.sleep(500);
            //    if(i%2==0)
                wait();
                notify();
                // if(i%2==1)
                // notify();
            } catch (InterruptedException ie) {
            }
        }
       System.out.println(Thread.currentThread().getName()+"-"+"interrupted:"+Thread.interrupted()+"-"+"alive:"+Thread.currentThread().isAlive());
       
    }

    // 修饰代码块，这个this就是指当前对象（类的实例），多个线程调用同一个对象的同步方法会阻塞，
    // 调用不同对象的同步方法不会阻塞。（java对象的内存地址是否相同）
    public void test02() {
        synchronized (this) {
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    // Thread.sleep(500);
                    // if(i%2==0)
                    notify();
                    wait(1000);
                   
                } catch (InterruptedException ie) {
                }
            }
            System.out.println(Thread.currentThread().getName()+"-"+"interrupted:"+Thread.interrupted()+"-"+"alive:"+Thread.currentThread().isAlive());

            
        }
    }

//修饰代码块，这个str就是指String对象，多个线程调用同一个对象的同步方法会阻塞， 
//调用不同对象的同步方法不会阻塞。（java对象的内存地址是否相同）
    public void test03() {
        // 在方法体内，调用一次就实例化一次，多线程访问不会阻塞，因为不是同一个对象，锁是不同的
        String str = new String("lock");
        synchronized (str) {
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {

                }
            }
        }
    }

    public void test04() {
        // 这里的str是类对象的成员，多线程访问会阻塞
        synchronized (str) {
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                // try {

                // } catch (InterruptedException ie) {
                // }
            }
        }
    }

    public static synchronized void test05() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public void test06() {
        synchronized (SynchronizedTest.class) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

}
