package com.my.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/21 17:09
 */
public class TinyUrl {
    public static void main(String[] args) {
        TinyUrl tinyUrl = new TinyUrl();
        String s = "dsadada";
        tinyUrl.encode(s);
        System.out.println(tinyUrl.get("s"));
    }

    private final String index = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final char[] chars = index.toCharArray();
    private final String URL = "http://tinyint.com/";
    private Map<String, String> map = new HashMap<>();

    public void encode(String url) {

        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (; ; ) {
            StringBuilder stringBuilder = new StringBuilder(6);
            int s = chars.length;
            for (int i = 0; i < 6; i++) {
                stringBuilder.append(chars[random.nextInt(s)]);
            }
            String r = stringBuilder.toString();
            if (map.get(r) != null) {
                continue;
            } else {
                map.put(url, URL + r);
                break;
            }
        }


    }

    public String get(String url) {
        String key = url.substring(url.lastIndexOf('/'));
        return map.get(key);
    }


}
