package com.my.thread;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/2 20:53
 */
public class TwoThread {

    private volatile boolean flag;
    private static CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList();

    private static class Ji implements Runnable {
        private TwoThread twoThread;

        public Ji(TwoThread twoThread) {
            this.twoThread = twoThread;
        }

        @Override
        public void run() {
            int s = 1;
            while (s <= 1000) {
                if (twoThread.flag) {
                    System.out.println(s);
                    copyOnWriteArrayList.add(s);
                    s = s + 2;
                    twoThread.flag = false;
                }
            }
        }
    }

    private static class Ou implements Runnable {
        private TwoThread twoThread;

        public Ou(TwoThread twoThread) {
            this.twoThread = twoThread;
        }

        @Override
        public void run() {
            int s = 0;
            while (s <= 1000) {
                if (!twoThread.flag) {
                    System.out.println(s);
                    copyOnWriteArrayList.add(s);
                    s = s + 2;
                    twoThread.flag = true;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TwoThread twoThread = new TwoThread();
        Thread ji = new Thread(new Ji(twoThread));
        Thread ou = new Thread(new Ou(twoThread));
        ji.start();
        ou.start();
        Thread.sleep(5000);
        List<Integer> list = TwoThread.copyOnWriteArrayList;
        System.out.println(Arrays.toString(list.toArray()));
        Map<Integer, List<Integer>> map = list.stream().collect(Collectors.groupingBy(Function.identity()));
        map.forEach((k,v)->{
            if(v.size()>1){
                System.out.println(k);
                System.out.println(v.size());
            }

        });
        System.out.println("结束");
    }


}
