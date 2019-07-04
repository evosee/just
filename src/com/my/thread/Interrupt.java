package com.my.thread;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/7/4 11:27
 */
public class Interrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(new Inner());
        thread.start();
        thread.interrupt();
    }

    static class Inner implements Runnable{

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("Inner do");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
