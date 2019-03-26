package com.my.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chensai
 * @Date: 2019/3/20 11:05
 * @Version 1.0
 * 将泛型映射到键上而不是容器上
 */
public class GenericTest {
    private Map<Class<?>, Object> map = new HashMap<>();

    public <T> T getObject(Class<T> tClass) {
        return tClass.cast(map.get(tClass));
    }

    public <T> void putObject(Class<T> tClass, T t) {
        map.put(tClass, tClass.cast(t));
    }

    public static void main(String[] args) {
        GenericTest genericTest = new GenericTest();
        genericTest.putObject(Integer.class,5);
        genericTest.putObject(String.class,"string");
        System.out.println(genericTest.getObject(Integer.class));
        System.out.println(genericTest.getObject(String.class));

    }
}
