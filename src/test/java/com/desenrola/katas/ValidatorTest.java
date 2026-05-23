package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
// Test
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void filterEvenNumbers() {
        List<Integer> result = Validator.filter(
            List.of(1, 2, 3, 4, 5),
            n -> n % 2 == 0
        );
        assertEquals(List.of(2, 4), result);
    }

    @Test
    void filterStringsStartingWithA() {
        List<String> result = Validator.filter(
            List.of("Ana", "Bob", "Alice", "Carlos"),
            s -> s.startsWith("A")
        );
        assertEquals(List.of("Ana", "Alice"), result);
    }
}
