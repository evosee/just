package com.my.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: chensai
 * @Date: 2018/12/3 17:15
 * @Version 1.0
 */
public class MyCollections {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");

        List<String> subList = new ArrayList<>();
        subList.add("c");
        subList.add("d");
        subList.add("e");
        System.out.println(Collections.indexOfSubList(a,subList));
    }
}
