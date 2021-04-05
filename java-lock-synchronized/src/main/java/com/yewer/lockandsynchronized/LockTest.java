package com.yewer.lockandsynchronized;

import java.util.concurrent.locks.*;

public class LockTest implements Runnable {

    /**
     * synchronized和lock的不同 1.sychronized在执行完相应代码块以后属于自动释放同步监视器，lock需要手动启动同步
     * 建议优先使用lock->同步方法块->同步方法(在方法体之外)
     * 
     * 实现Runnable对象被三个线程调用，然后这个对象的run方法里贡献资源操作器被lock上锁了
     * 
     */
    // ReentrantLock和ReentrantReadWriteLock，它默认情况下是非公平锁
    private Lock lock = new ReentrantLock(true);
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticket--) + "张票。");
            }
            // else {
            // lock.unlock();
            // return;
            // }
            lock.unlock();
        }
    }
}
