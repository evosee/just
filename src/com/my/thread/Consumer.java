package com.my.thread;

import java.util.List;

/**
 * @Author: chensai
 * @Date: 2018/12/12 15:40
 * @Version 1.0
 */
public class Consumer implements Runnable{
    private List<Integer> integers;

    public Consumer(List<Integer> integers) {
        this.integers = integers;
    }
    @Override
    public void run() {
        consume();
    }

    public void consume(){
        synchronized (integers){
            while (integers.size()==0){
                try {
                    integers.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("c");
            integers.remove(0);
            integers.notifyAll();

        }
    }
}
