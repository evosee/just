package com.my.huawei;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/21 15:36
 */
public class Test3 {
    public static void main(String[] args) {
        String x=  "aaacccddef";
        System.out.println(getString(x));
    }
    public static String getString(String a){
        char[] chars = a.toCharArray();
        StringBuilder builder = new StringBuilder(a.length());
        char x = chars[0];
        int j = 1;
        for(int i=1;i<chars.length;i++){
            char c = chars[i];
            if(c==x){
                j++;
                continue;
            }else {
                 builder.append(x);
                x = c;
            }
            if(j!=1) builder.append(j);
            j=1;
        }
        builder.append(chars[chars.length-1]);
        if(j!=1) builder.append(j);
        return builder.toString();
    }
}
