package com.my.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chensai
 * @Date: 2018/12/12 15:46
 * @Version 1.0
 */
public class ThreadMain {
    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>();
        Thread c1 = new Thread(new Consumer(lists),"c1");
        Thread c2 = new Thread(new Consumer(lists),"c2");

        Thread p1 = new Thread(new Producer(lists),"p1");
        Thread p2 = new Thread(new Producer(lists),"p2");

        c1.start();
        c2.start();
        p1.start();
        p2.start();
    }


}
