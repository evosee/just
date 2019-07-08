package com.my.json;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/7/5 17:21
 */
public class JsonTocken implements Tocken{

    private int beginIndex;
    private boolean flag;
    public JsonTocken() {
        this.beginIndex = 1;
    }

    public String nextString(String json) {

        int index = json.indexOf(',', beginIndex);
        if (index == -1) {

            String f = json.substring(beginIndex, json.length()-1);
            flag = true;
            return f;
        }
        String s = json.substring(beginIndex, index);
        //说明是数组
        if (s.indexOf('[') != -1) {
            //继续找
            int endIndex = json.indexOf(']', beginIndex);
            s = json.substring(beginIndex, endIndex + 1);
            beginIndex = endIndex + 2;
        } else if (s.indexOf('{') != -1) {
            int endIndex = json.indexOf('}', beginIndex);
            s = json.substring(beginIndex, endIndex + 1);
            beginIndex = endIndex + 2;
        } else {
            beginIndex = index + 1;
        }
        return s;
    }

    @Override
    public Map<String, String> getMap(String json) {
        Map<String, String> map = new HashMap<>();


        for (; ; ) {
            if (flag) break;
            String s = nextString(json);
            String[] r = s.split(":");

            if (r.length > 2) {
                String k = s.substring(0, s.indexOf(':'));
                k = getTrim(k);
                String v = s.substring(s.indexOf(':') + 1);
                v = getTrim(v);
                map.put(k, v);
            } else {
                String k = r[0];
                String v = r[1];
                v = getTrim(v);
                k = getTrim(k);
                map.put(k, v);
            }

        }
        return map;
    }

    private String getTrim(String v) {
        return v.replace("\"", "").trim();
    }

}
