package com.my.json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/7/8 11:36
 */
public class ArrayTocken {
    private final String json;
    private int beginIndex;
    private final List<String> mapList;

    public ArrayTocken(String json) {
        this.json = json.replace(" ", "");
        this.mapList = new ArrayList<>();
        this.beginIndex = 1;
    }

    public List<String> getJson() {
        if (!json.startsWith("[") || !json.endsWith("]"))
            throw new RuntimeException("not a json array");
        getString(mapList);
        return mapList;

    }

    private void getString(List<String> stringList) {
        int lastIndex = json.indexOf("},{", beginIndex) + 1;
        String s;

        if (lastIndex == 0) {
            s = json.substring(beginIndex, json.lastIndexOf(']'));
            beginIndex = -1;
            stringList.add(s);
            return;
        } else {
            s = json.substring(beginIndex, lastIndex);
            beginIndex = lastIndex + 1;
            getString(stringList);
        }
        stringList.add(s);


    }

}
