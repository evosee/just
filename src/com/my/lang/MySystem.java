package com.my.lang;

public class MySystem {
    public static void main(String[] args) {
        /*System.getProperties().forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
            System.out.println("_____________________________");
        });*/
        System.getenv().forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
            System.out.println("_____________________________");
        });
    }
}
