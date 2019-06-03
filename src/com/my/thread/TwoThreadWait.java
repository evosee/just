package com.my.thread;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/3 15:01
 */
public class TwoThreadWait {
    private boolean flag = true;

    private static class Ji implements Runnable{
        private TwoThreadWait twoThreadWait;
        public Ji(TwoThreadWait twoThreadWait){
            this.twoThreadWait = twoThreadWait;
        }

        public void print() throws InterruptedException {
            int s = 1;
            for(;s<=100;){
                synchronized (twoThreadWait){
                    if(twoThreadWait.flag){
                        System.out.println(s);
                        s = s+2;
                        twoThreadWait.flag = false;
                        twoThreadWait.notify();
                    }else {
                        twoThreadWait.wait();
                    }
                }
            }

        }

        @Override
        public void run() {
            try {
                print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static class Ou implements Runnable{
        private TwoThreadWait twoThreadWait;
        public Ou(TwoThreadWait twoThreadWait){
            this.twoThreadWait = twoThreadWait;
        }

        public void print() throws InterruptedException {
            int s = 2;
            for(;s<=100;){
                synchronized (twoThreadWait){
                    if(!twoThreadWait.flag){
                        System.out.println(s);
                        s = s+2;
                        twoThreadWait.flag = true;
                        twoThreadWait.notify();

                    }else {
                        twoThreadWait.wait();
                    }
                }
            }

        }

        @Override
        public void run() {
            try {
                print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TwoThreadWait twoThreadWait = new TwoThreadWait();
        Thread thread = new Thread(new Ji(twoThreadWait));
        Thread thread2 = new Thread(new Ou(twoThreadWait));
        thread.start();
        thread2.start();
    }
}
