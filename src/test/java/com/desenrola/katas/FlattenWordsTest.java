package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
// Test
import org.junit.jupiter.api.Test;

class FlattenWordsTest {

    @Test
    void flattensNestedLists() {
        List<List<String>> groups = List.of(
            List.of("a", "b"),
            List.of("c"),
            List.of("d", "e")
        );
        assertEquals(
            List.of("a", "b", "c", "d", "e"),
            StreamExercises.flattenWords(groups)
        );
    }

    @Test
    void emptyGroupsReturnEmpty() {
        assertEquals(List.of(), StreamExercises.flattenWords(List.of()));
    }
}
