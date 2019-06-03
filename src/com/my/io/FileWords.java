package com.my.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/3 16:45
 */
public class FileWords {
    public List<Map.Entry<String, Integer>> getWords(String[] a, String path) throws Exception {
        Path path1 = Paths.get(path);
        File file = path1.toFile();

        Map<String, Integer> map = new HashMap<>(a.length);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Stream<String> stringStream = reader.lines();

            stringStream.forEach(e -> {
                for (String s : a) {
                    Pattern pattern = Pattern.compile(s);
                    Matcher matcher = pattern.matcher(e);
                    int i = 0;
                    while (matcher.find()) {
                        i++;
                    }
                    Integer x = map.get(s);
                    if (x == null) {
                        x = 0;
                    }
                    map.put(s, x + i);
                }
            });
        }

        List<Map.Entry<String, Integer>> list = map.entrySet().stream().sorted((o1, o2) -> o2.getValue()-o1.getValue()).collect(Collectors.toList());
        return list;
    }

    public static void main(String[] args) throws Exception {
        FileWords fileWords = new FileWords();
        String[] a = {"abc", "abd", "abe"};
        List<Map.Entry<String, Integer>> list  = fileWords.getWords(a, "D:\\test.txt");
        list.forEach(e->{
            System.out.println(e.getKey());
            System.out.println("出现次数:"+e.getValue());
        });
    }
}
