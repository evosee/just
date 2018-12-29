package com.my.thread;

/**
 * @Author: chensai
 * @Date: 2018/12/29 15:35
 * @Version 1.0
 */
public class DeadLock {
    private Object lObject = new Object();
    private Object rObject = new Object();

    public void left() {
        synchronized (lObject) {
            try {
                Thread.sleep(2000);
                synchronized (rObject) {

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void right() {
        synchronized (rObject) {
            try {
                Thread.sleep(2000);
                synchronized (lObject) {

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        Thread thread = new Thread(()->deadLock.left());
        Thread thread2 = new Thread(()->deadLock.right());
        thread.start();
        thread2.start();

    }
}
