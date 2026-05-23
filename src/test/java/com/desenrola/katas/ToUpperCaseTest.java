package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
// Test
import org.junit.jupiter.api.Test;

class ToUpperCaseTest {

    @Test
    void convertsToUpperCase() {
        List<String> result = StreamExercises.toUpperCase(
            List.of("java", "streams")
        );
        assertEquals(List.of("JAVA", "STREAMS"), result);
    }

    @Test
    void emptyListReturnsEmpty() {
        assertEquals(List.of(), StreamExercises.toUpperCase(List.of()));
    }

    @Test
    void alreadyUppercaseUnchanged() {
        assertEquals(
            List.of("A", "B"),
            StreamExercises.toUpperCase(List.of("A", "B"))
        );
    }
}
