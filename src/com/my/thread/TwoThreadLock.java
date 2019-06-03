package com.my.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/3 15:50
 */
public class TwoThreadLock {
    private boolean flag;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private static class Ji implements Runnable {
        private TwoThreadLock twoThreadLock;

        public Ji(TwoThreadLock twoThreadLock) {
            this.twoThreadLock = twoThreadLock;
        }


        @Override
        public void run() {
            int s = 1;
            Lock lock = twoThreadLock.lock;
            Condition condition = twoThreadLock.condition;

            for (; s <= 100; ) {
                try {
                    lock.lock();
                    if (!twoThreadLock.flag) {
                        System.out.println(s);
                        s = s + 2;
                        twoThreadLock.flag = true;

                    }
                }  finally {
                    lock.unlock();
                }
            }

        }
    }

    private static class Ou implements Runnable {
        private TwoThreadLock twoThreadLock;

        public Ou(TwoThreadLock twoThreadLock) {
            this.twoThreadLock = twoThreadLock;
        }


        @Override
        public void run() {
            int s = 2;
            Lock lock = twoThreadLock.lock;
            Condition condition = twoThreadLock.condition;

            for (; s <= 100; ) {
                try {
                    lock.lock();
                    if (twoThreadLock.flag) {
                        System.out.println(s);
                        s = s + 2;
                        twoThreadLock.flag = false;

                    }
                }  finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        TwoThreadLock twoThreadLock = new TwoThreadLock();
        Thread thread = new Thread(new Ji(twoThreadLock));
        Thread thread2 = new Thread(new Ou(twoThreadLock));
        thread.start();
        thread2.start();

    }
}
