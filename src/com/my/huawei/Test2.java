package com.my.huawei;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/21 15:18
 */
public class Test2 {
    public static void main(String[] args) {
        Test2.test(201,604);
    }
    public static int test(int heads,int foots){
        if(foots%2!=0) return -1;


        if((4*heads - foots)%2!=0) return -1;
        int j = (4*heads - foots)/2;
        int t = heads-j;

        System.out.println("鸡："+j);
        System.out.println("兔："+t);
        return 0;

    }
}
