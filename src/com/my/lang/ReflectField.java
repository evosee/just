package com.my.lang;

import java.lang.reflect.Field;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/4/15 17:10
 */
public class ReflectField {
    private    int i;
}

class Test{
    public static void main(String[] args) throws Exception {
        Field field = ReflectField.class.getDeclaredField("i");
        field.setAccessible(true);
        ReflectField reflectField = new ReflectField();
        field.set(reflectField,14);
        System.out.println(field.get(reflectField));
    }
}


