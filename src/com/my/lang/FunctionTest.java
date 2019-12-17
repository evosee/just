package com.my.lang;

import java.util.function.Function;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/12/2 10:55
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<String,String> function = Function.identity();

        System.out.println(function.apply("s"));
    }
}
