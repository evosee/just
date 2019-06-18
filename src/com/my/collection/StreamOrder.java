package com.my.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/4/25 15:24
 */
public class StreamOrder {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add(i);
        }
        list.parallelStream().forEach(e-> System.out.println(e));
    }
}
