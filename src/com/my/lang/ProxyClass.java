package com.my.lang;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyClass {
    static class My implements ProxyInterface{

        @Override
        public void test() {
            System.out.println("i am test");
        }

        @Override
        public void test1() {
            System.out.println("test2");
        }
    }

    public static void main(String[] args) {
        My m = new My();
        ProxyInterface p = (ProxyInterface) Proxy.newProxyInstance(My.class.getClassLoader(), My.class.getInterfaces(), (proxy, method, args1) -> {
            method.invoke(m, args1);
            return null;
        });
      p.test1();
    }
}
