package com.my.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chensai
 * @Date: 2018/12/3 14:39
 * @Version 1.0
 * 泛型
 */
public class GenericityClass {
    public static void main(String[] args) {
        /*List<? super Number> numbers = new ArrayList<>();
        numbers.add(new Integer(1));
        numbers.add(new Double(1));
        Number n = numbers.get(1);//编译不通过
        System.out.println(n);*/

        List<? extends Number> numbers = new ArrayList<>();
       // numbers.add(new Integer(1));//编译不通过
        Number n = numbers.get(0);
        System.out.println(n);
    }
}
