package com.yewer.thread_lock_sync;

import java.util.concurrent.*;

public class ThreadPoolTest {
    private static ThreadPoolTest ourInstance = new ThreadPoolTest();

    public static ThreadPoolTest getInstance() {
        return ourInstance;
    }

    private ThreadPoolTest() {
    }

  public static void main(String[] args) {
      ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,3, TimeUnit.MINUTES,new LinkedBlockingQueue<>(10));
      MyRun myrun=new MyRun(100);
    for (int i = 0; i < 20; i++) {
          threadPoolExecutor.execute(myrun);
          //;
    }

  }
}
