package com.desenrola.katas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExercises {

    public static Map<Integer, List<String>> groupByLength(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    public static String joinWords(List<String> words, String delimiter) {
        return words.stream().collect(Collectors.joining(delimiter));
    }

    public static String joinWithBrackets(List<String> words) {
        return words.stream().collect(Collectors.joining(", ", "[", "]"));
    }

}
