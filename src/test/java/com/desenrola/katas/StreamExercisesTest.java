package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
// Test
import org.junit.jupiter.api.Test;

class StreamExercisesTest {

    @Test
    void countWordsLongerThan4() {
        List<String> words = List.of("hi", "hello", "world", "java", "streams");
        assertEquals(3, StreamExercises.countLongWords(words, 5));
    }

    @Test
    void countWithEmptyListIsZero() {
        assertEquals(0, StreamExercises.countLongWords(List.of(), 3));
    }

    @Test
    void countAllWhenMinLengthIsOne() {
        List<String> words = List.of("a", "bb", "ccc");
        assertEquals(3, StreamExercises.countLongWords(words, 1));
    }
}
