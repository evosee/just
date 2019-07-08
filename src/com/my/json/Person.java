package com.my.json;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/7/5 11:25
 */
public class Person {




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    private String name;
    private String age;
    Person p;

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }
}
