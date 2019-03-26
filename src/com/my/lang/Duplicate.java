package com.my.lang;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 去重
 * @author chensai
 * @version 1.0
 * @date 2019/3/26 11:25
 */
public class Duplicate {
    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(2);
        lists.add(4);
     //   System.out.println(Arrays.toString(stream(lists).toArray()));
        System.out.println(Arrays.toString(duplicate(lists).toArray()));
    }
    /** 获取重复元素stream*/
    public  static <E> List<E> stream(List<E> list){
      return   list.stream().collect(Collectors.toMap(Function.identity(),e->1,Integer::sum))
                .entrySet().stream().filter(f->f.getValue()>1).map(x->x.getKey()).collect(Collectors.toList());
    }
    public  static <E> List<E> duplicate(List<E> list){
        Map<E,Integer> map = new HashMap<>();
        for(E e : list){
            Integer i = map.get(e);
            if(i==null){
                map.put(e,1);
            }else {
                Integer x = map.get(e);
                x++;
                map.put(e,x);
            }
        }
      return   map.entrySet().stream().filter(e->e.getValue()>1).map(x->x.getKey()).collect(Collectors.toList());
    }
}
