package com.my.lang;

import java.lang.reflect.Proxy;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/4/15 14:58
 */
public class NoObjectProxy {
    public static void main(String[] args) {
        ProxyInterface proxyInterface= (ProxyInterface) Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(), new Class[]{ProxyInterface.class}, (proxy, method, args1) -> null);

        proxyInterface.test();
    }
}
