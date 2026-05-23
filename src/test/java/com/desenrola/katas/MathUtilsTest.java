package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

// Test
import org.junit.jupiter.api.Test;

class MathUtilsTest {

    @Test
    void maxOfIntegers() {
        assertEquals(10, MathUtils.max(3, 10));
    }

    @Test
    void maxOfStrings() {
        assertEquals("zebra", MathUtils.max("apple", "zebra"));
    }

    @Test
    void maxWhenEqualReturnsEither() {
        assertEquals(5, MathUtils.max(5, 5));
    }
}
