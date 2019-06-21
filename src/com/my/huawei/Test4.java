package com.my.huawei;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/21 16:12
 */
public class Test4 {
    public static void main(String[] args) {
        System.out.println(get(21099));
    }
    public static int get(int x){

         for(;;){
            int p = ++x;
            //判断连续两位有没有重复
            String pp = String.valueOf(p);
            char[] chars = pp.toCharArray();
            int i=0;
            char c = chars[i];
            while (++i<chars.length){
                char next = chars[i];
                if(c==next){
                    break;
                }else {
                    if(i==chars.length-1){
                        return p;
                    }
                     c = next;

                }
            }

        }

    }

}
