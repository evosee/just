package com.my.lang;

import java.lang.reflect.Field;

/**
 * @Author: chensai
 * @Date: 2018/12/13 19:45
 * @Version 1.0
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = 13;
        Integer b = 1511;
        System.out.println(a);
        System.out.println(b);
        swap2(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    public static void swap(Integer a, Integer b) {
        int c = a;
        a = b;
        b = c;
        System.out.println(a);
        System.out.println(b);
    }
    public static void swap2(Integer a,Integer b){
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            Integer t = new Integer(a.intValue());
            System.out.println(t==a);
            field.set(a,b);
            field.set(b,t);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
