package com.my.thread;

public class ThreadJoin {
    public static void main(String[] args) {
        Thread a = new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println("a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread b  = new Thread(()-> {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b");
        });
        a.start();
        b.start();
        //Thread.dumpStack();
Thread.getAllStackTraces().forEach((k,v)->{
    System.out.println(k);
    if(v.length>0){
        System.out.println(v[0].toString());
    }

});
    }
}
