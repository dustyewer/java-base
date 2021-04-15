package com.yewer.thread_lock_sync;

public class Kaoshi {
    public int fun(){
//        static int i=0;
        int i=0;
        i++;
        return i;
    }

    public static void main(String[] args){
        Kaoshi kaoshi = new Kaoshi();
        kaoshi.fun();
        int j=kaoshi.fun();
        System.out.println(j);
    }
}
