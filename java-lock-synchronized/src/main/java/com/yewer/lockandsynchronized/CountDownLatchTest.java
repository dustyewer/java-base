package com.yewer.lockandsynchronized;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String args[]) throws InterruptedException {
        
        


        CountDownLatch countDownLatch = new CountDownLatch(2);
        countDownLatch.wait();
    }
    
}
