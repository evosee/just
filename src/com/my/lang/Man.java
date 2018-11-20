package com.my.lang;


import jdk.nashorn.internal.runtime.logging.Logger;

import java.util.ArrayList;
import java.util.List;

public class Man<T> extends Person {
    @TestAn
    private String addr;
    Person p;
    List<String> lists;

    public <T> T getLists(@Logger List<String> e,@Logger Object o) {
        List<String> lists = new ArrayList<>();
        return (T) lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }
}
