package com.desenrola.katas;

import java.util.List;

public class Formatter {

    public static List<String> formatAll(List<String> words) {
        return words.stream().map(String::toUpperCase).toList();
    }

    public static void printAll(List<String> list) {
        list.stream().forEach(System.out::println);
    }

    public static List<Long> parseLongs(List<String> numbers) {
        return numbers.stream().map(Long::parseLong).toList();
    }
}
