package com.my.collection;

import java.util.EnumMap;
import java.util.Map;

/**
 * @Author: chensai
 * @Date: 2018/12/4 15:02
 * @Version 1.0
 */
public class MyEnumMap {
    public static void main(String[] args) {

        EnumMap<MyEnum,String> enumMap = new EnumMap(MyEnum.class);
        enumMap.put(MyEnum.a,"a");
        enumMap.put(MyEnum.c,"c");
        System.out.println(enumMap);
    }

    static enum MyEnum {
        a,b,c
    }
}
