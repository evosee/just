package com.my.json;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/7/5 11:17
 */
public class JsonParse {

    public <T> T parse(String json, Class<T> clazz) throws Exception {
        json = json.trim().replace("\n", "");
        if (!json.startsWith("{") || !json.endsWith("}")) {
            throw new RuntimeException("不是json字符串");
        }
        Map<String, String> map = new Tocken(json).getMap();
        Map<String, Field> fieldMap = getFields(clazz);
        T o = clazz.newInstance();
        fieldMap.forEach((k, v) -> {
            v.setAccessible(true);
            String value = map.get(k);
            Object r = null;
            if (value != null) {
                if (value.startsWith("{")) {
                    try {
                        r = parse(value, v.getDeclaringClass());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (value.startsWith("[")) {
                    value = value.replace("\"", "");
                    value = value.replace(" ","");
                    if (value.indexOf("{") == -1) {
                        value = value.substring(1,value.lastIndexOf("]"));
                        r = Arrays.asList(value.split(","));
                    } else {
                        List<Object> lists = new ArrayList<>();
                        List<String> stringList = new ArrayTocken(value).getJson();
                        for (String x : stringList) {
                            ParameterizedType parameterizedType = (ParameterizedType) v.getGenericType();
                            try {
                                Object ob = parse(x, (Class<T>) parameterizedType.getActualTypeArguments()[0]);
                                lists.add(ob);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        r = lists;
                    }
                } else {
                    r = value;
                }
                try {
                    String typeName = v.getGenericType().getTypeName();
                    Object o1 = r;
                    if (typeName.equals("boolean")||typeName.equals("java.lang.Boolean")) {
                        o1 = Boolean.getBoolean(r.toString());
                    } else if (typeName.equals("java.lang.Integer")) {
                        o1 = Integer.parseInt(r.toString());
                    }else if (typeName.equals("java.lang.Long")) {
                        o1 = Long.parseLong(r.toString());
                    }
                    v.set(o, o1);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        return o;
    }


    public Map<String, Field> getFields(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        return Stream.of(fields).collect(Collectors.toMap(Field::getName, Function.identity()));
    }

    public static void main(String[] args) throws Exception {
        String a = "{\n" +
                "   \"beginTime\" : 1547827200,\n" +
                "   \"city\" : \"510100\",\n" +
                "   \"continuation\" : \"true\",\n" +
                "   \"count\" : \"001\",\n" +
                "   \"endTime\" : 1548345600,\n" +
                "   \"moreTwo\" : \"true\",\n" +
                "   \"persons\" : [\n" +
                "      {\n" +
                "         \"age\" : \"12\",\n" +
                "         \"name\" : \"a\",\n" +
                "         \"p\" : {\n" +
                "            \"name\" : \"1232\"\n" +
                "         }\n" +
                "      },\n" +
                "      {\n" +
                "         \"age\" : \"23\",\n" +
                "         \"name\" : \"b\",\n" +
                "         \"p\" : {\n" +
                "            \"name\" : \"12222\"\n" +
                "         }\n" +
                "      }\n" +
                "   ],\n" +
                "   \"premiseIds\" : [ \"277823\", \"277825\", \"277822\", \"618429\" ],\n" +
                "   \"second\" : \"003\",\n" +
                "   \"trade\" : \"H01701\",\n" +
                "   \"type\" : \"003\"\n" +
                "}\n";

        MatchPremiseParam p = new JsonParse().parse(a, MatchPremiseParam.class);
        System.out.println(p.getPersons().size());

    }
}
