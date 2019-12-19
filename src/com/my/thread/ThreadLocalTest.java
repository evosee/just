package com.my.thread;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/19 10:00
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

    public Integer get(){
        return integerThreadLocal.get();
    }
    public void set(Integer integer){
        integerThreadLocal.set(integer);
    }

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.set(1);
        System.out.println(threadLocalTest.get());

        ThreadLocalTest threadLocalTest2 = new ThreadLocalTest();
        threadLocalTest.set(2);
        System.out.println(threadLocalTest2.get());
        System.out.println(threadLocalTest.get());
    }
}
