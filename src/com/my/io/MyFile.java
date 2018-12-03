package com.my.io;

import java.io.File;
import java.util.Arrays;

public class MyFile {
    public static void main(String[] args) {
     // File[] files =   File.listRoots();
       // System.out.println(Arrays.toString(files));
        File file = new File("D:\\test\\test.txt");
        System.out.println(file.getTotalSpace()/1024/1024/1024);
        System.out.println(file.getUsableSpace()/1024/1024/1024);
        System.out.println(file.getFreeSpace()/1024/1024/1024);
    }
}
