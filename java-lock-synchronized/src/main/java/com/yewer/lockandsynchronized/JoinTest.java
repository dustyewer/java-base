package com.yewer.lockandsynchronized;


public class JoinTest {
    private int i;
    public static void main(String[] args){
        new JoinTest().test();
    }

    void test(){
        MyRun r1= new MyRun(10);
        MyRun r2= new MyRun(5);
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        r2.setT(t1);
        t1.start();
        t2.start();
        try {
            // t1.join();
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("我是"+Thread.currentThread().getName()+"我等t1:"+t2.getName()+"了？");
    }

}
