package com.desenrola.katas;

import java.util.List;
import java.util.function.Predicate;

public class Validator {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).toList();
    }
}
