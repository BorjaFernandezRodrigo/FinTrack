package com.desenrola.katas;

// Test
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class JoiningTest {

    @Test
    void joinWithComma() {
        assertEquals("a,b,c", GroupingExercises.joinWords(List.of("a", "b", "c"), ","));
    }

    @Test
    void joinWithSpace() {
        assertEquals("hello world", GroupingExercises.joinWords(List.of("hello", "world"), " "));
    }

    @Test
    void joinWithBrackets() {
        assertEquals("[a, b, c]", GroupingExercises.joinWithBrackets(List.of("a", "b", "c")));
    }
}