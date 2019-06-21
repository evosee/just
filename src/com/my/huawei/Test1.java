package com.my.huawei;

import java.util.Arrays;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/21 14:01
 * <p>
 * 1） 输入：num = 12，time = 3，input =[1,2,3,3,1,3,1,1,1,1,2,3]
 * <p>
 * 输出：output = [1,2,3,0,0,3,1,0,0,1,2,3]
 * <p>
 * 2） 输入：num = 11，time = 4，intput = [1,2,3,4,2,3,3,4,1,2,3]
 * <p>
 * 输出：output = [1,2,3,4,0,0,3,4,1,2,3]
 */
public class Test1 {
    public static void main(String[] args) {
       /*int num = 12,time = 3;
       int[] input ={1,2,3,3,1,3,1,1,1,1,2,3};*/
        int num = 11,time = 4;
        int[] input ={1,2,3,4,2,3,3,4,1,2,3};

        System.out.println(Arrays.toString(test(num,time,input)));
    }
    public static int[] test(int num, int time, int[] input) {
        //先获取正确的位置
        int[] a = new int[num];
        int p = num / time;
        //余数
        int y = num % time;
        int i = 0;
        for (int j = 0; j < p; j++) {
            for (int x = 1; x <= time; x++) {
                a[i] = x;
                i++;
            }
        }
        if (y != 0) {
            for (int x = 1; x <= y; x++) {
                a[i] = x;
                i++;
            }
        }

        //对比输出
        for(int j=0;j<num;j++){
            if(a[j]!=input[j]){
                a[j] = 0;
            }
        }
        return a;
    }
}

