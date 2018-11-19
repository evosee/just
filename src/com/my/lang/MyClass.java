package com.my.lang;

import jdk.nashorn.internal.runtime.logging.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MyClass {
    public static void main(String[] args) {
        //System.out.println(ArrayList.class.toGenericString());
    // Object[] o =    ArrayList.class.getSigners();
      //  Constructor[] c = HashSet.class.getConstructors();
        try {
          //  Class[] c = Man.class.getDeclaredClasses();
           Field field =  Man.class.getDeclaredField("addr");
            TestAn c=  field.getAnnotation(TestAn.class);
            Logger logger = c.annotationType().getAnnotation(Logger.class);
            System.out.println(logger);
         // Annotation[] c =  field.getAnnotations();
           // Annotation[] c=  field.getDeclaredAnnotations();
           // System.out.println(Arrays.toString(c));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
