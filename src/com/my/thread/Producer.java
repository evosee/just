package com.my.thread;

import java.util.List;

/**
 * @Author: chensai
 * @Date: 2018/12/12 15:40
 * @Version 1.0
 */
public class Producer implements Runnable {

    private List<Integer> integers;

    public Producer(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        producer();
    }

    public void producer() {
        synchronized (integers) {
            while (integers.size() == 1) {
                try {
                    integers.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("p");
            integers.add(1);
            integers.notifyAll();

        }

    }
}
