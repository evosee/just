package com.my.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/11/28 15:07
 * <p>
 * 模拟ThreadLocal的原理
 */
public class ThreadLocalUtil<V> {
    private Map<Thread, V> map = new HashMap<>();

    public void set(V v) {
        map.put(Thread.currentThread(), v);
    }

    public V get() {
        return map.get(Thread.currentThread());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalUtil<Integer> integerThreadLocal = new ThreadLocalUtil<>();

        Thread thread = new Thread(() -> {integerThreadLocal.set(0);
            System.out.println(integerThreadLocal.get());});
        Thread thread1 = new Thread(() -> {
            integerThreadLocal.set(1);
            System.out.println(integerThreadLocal.get());
        });
        Thread thread2 = new Thread(() -> integerThreadLocal.set(2));
        Thread thread3 = new Thread(() -> integerThreadLocal.set(3));
        Thread thread4 = new Thread(() -> integerThreadLocal.set(4));
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        Thread.sleep(3000);
        System.out.println(integerThreadLocal.get());


    }
}
