package com.my.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: chensai
 * @Date: 2018/12/29 10:02
 * @Version 1.0
 */
public class CyclicBarrrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        Thread thread = new Thread(()->{
            try {
                System.out.println("1开始");
                cyclicBarrier.await();
                System.out.println("1结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(()->{
            try {
                System.out.println("2开始");
                cyclicBarrier.await();
                System.out.println("2结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread2.start();
    }
}
