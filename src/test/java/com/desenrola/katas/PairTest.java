package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

// Test
import org.junit.jupiter.api.Test;

class PairTest {

    @Test
    void pairHoldsValues() {
        Pair<String, Integer> p = new Pair<>("hello", 42);
        assertEquals("hello", p.first());
        assertEquals(42, p.second());
    }

    @Test
    void swapReturnsPairWithInvertedTypes() {
        Pair<String, Integer> p = new Pair<>("world", 7);
        Pair<Integer, String> swapped = p.swap();
        assertEquals(7, swapped.first());
        assertEquals("world", swapped.second());
    }
}
