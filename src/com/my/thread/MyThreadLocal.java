package com.my.thread;

public class MyThreadLocal {
    public static void main(String[] args) {

Thread threada = new Thread(()->{
    ThreadLocal local = new ThreadLocal();
    System.out.println(local.get());
});

threada.start();



    }
}
