package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

// Test
import org.junit.jupiter.api.Test;

class ArrayUtilsTest {

    @Test
    void swapIntegers() {
        Integer[] arr = { 1, 2, 3 };
        ArrayUtils.swap(arr, 0, 2);
        assertArrayEquals(new Integer[] { 3, 2, 1 }, arr);
    }

    @Test
    void swapStrings() {
        String[] arr = { "a", "b", "c" };
        ArrayUtils.swap(arr, 0, 1);
        assertArrayEquals(new String[] { "b", "a", "c" }, arr);
    }

    @Test
    void swapSameIndexDoesNothing() {
        Integer[] arr = { 10, 20, 30 };
        ArrayUtils.swap(arr, 1, 1);
        assertArrayEquals(new Integer[] { 10, 20, 30 }, arr);
    }
}
