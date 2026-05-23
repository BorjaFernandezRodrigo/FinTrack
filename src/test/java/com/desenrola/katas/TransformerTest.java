package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
// Test
import org.junit.jupiter.api.Test;

class TransformerTest {

    @Test
    void transformIntToString() {
        List<String> result = Transformer.transform(
            List.of(1, 2, 3),
            n -> "num" + n
        );
        assertEquals(List.of("num1", "num2", "num3"), result);
    }

    @Test
    void transformTwiceDoublesEffect() {
        // aplica x -> x + 10 dos veces: 1 -> 11 -> 21
        List<Integer> result = Transformer.transformTwice(
            List.of(1, 2, 3),
            n -> n + 10
        );
        assertEquals(List.of(21, 22, 23), result);
    }
}
