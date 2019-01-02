package com.my.lang;

/**
 * @Author: chensai
 * @Date: 2019/1/2 15:36
 * @Version 1.0
 */
public class AutoPackage {
    public static void main(String[] args) {
        int src = 65535;
        Integer t = new Integer(src);
        System.out.println(src==t);//这里触发自动拆箱也就是说==中有数字的情况会触发自动拆箱
        System.out.println(t.equals(src));
    }
}
