package com.my.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: chensai
 * @Date: 2019/1/18 14:25
 * @Version 1.0
 */
public class Words {

    public static List<String> getPaths(String source) {
        try {
            // URI uri = new URI(source);
            Path path = Paths.get(source);
            try (Stream<Path> pathStream = Files.walk(path)) {
                return pathStream.map(Path::toString).filter(e -> e.indexOf(".java") != -1).collect(Collectors.toList());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //责任链模式引入处理链
    public static int getCount(List<String> paths, List<WordsProcess> processes) {
        AtomicInteger result = new AtomicInteger();
        paths.stream().forEach(e -> {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(e));
                String line;
                while ((line = reader.readLine()) != null) {
                    String finalLine = line;
                    processes.forEach(p1 -> p1.process(finalLine));
                    result.getAndAdd(line.length());
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        return result.intValue();
    }

    public static int getCount2(List<String> paths) {
        AtomicInteger result = new AtomicInteger();
        paths.stream().forEach(e -> {
            try {
                Path path = Paths.get(e);
                List<String> s = Files.lines(path).collect(Collectors.toList());
                s.forEach(f -> {
                    System.out.println(f);
                    result.getAndAdd(f.length());
                });

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        return result.intValue();
    }

    public static void main(String[] args) {
        // String source = "file:///D://workspace";
        String source = "D://workspace";
        List<WordsProcess> processes = new ArrayList<>();
        processes.add(new WordsCheck());
        List<String> lists = getPaths(source);
        System.out.println(getCount(lists, processes));


    }


}
