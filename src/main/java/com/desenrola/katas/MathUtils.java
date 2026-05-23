package com.desenrola.katas;

public class MathUtils {

    static <T> T max(T a, T b) {
        return a.toString().compareTo(b.toString()) == 1 ? a : b;
    }
}
