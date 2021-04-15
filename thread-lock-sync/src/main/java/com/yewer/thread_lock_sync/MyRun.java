package com.yewer.thread_lock_sync;

public class MyRun implements Runnable {

    private Thread t;
    private int i;

    public MyRun(int i) {
        this.i = i;
    }

    @Override
      public void run() {
        if (t != null) {
            try {
                t.join();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        synchronized (this){
            while (i > 0) {
                i--;
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "  " + i);
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }


    public Thread getT() {
        return t;
    }

    public void setT(Thread t) {
        this.t = t;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

}
