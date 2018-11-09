package com.my.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapStream {
    public static void main(String[] args) {
        Integer[] a = {1,2,3};
        Integer[] b = {3,4};
        List<Integer> lista  = Arrays.asList(a);
        List<Integer> listb = Arrays.asList(b);

    List<int[]> lists =  lista.stream().flatMap(i->listb.stream().map(x->new int[]{i,x})).collect(Collectors.toList());
    }
}
