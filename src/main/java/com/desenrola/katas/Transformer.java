package com.desenrola.katas;

import java.util.List;
import java.util.function.Function;

public class Transformer {

    public static <T, R> List<R> transform(List<T> list, Function<T, R> fn) {
        return list.stream().map(fn).toList();
    }

    public static <T> List<T> transformTwice(List<T> list, Function<T, T> fn) {
        return list.stream().map(fn.andThen(fn)).toList();
    }
}
