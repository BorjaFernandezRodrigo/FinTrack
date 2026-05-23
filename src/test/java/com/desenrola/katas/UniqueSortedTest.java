package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
// Test
import org.junit.jupiter.api.Test;

class UniqueSortedTest {

    @Test
    void removesduplicatesAndSorts() {
        List<Integer> result = StreamExercises.uniqueSorted(
            List.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
        );
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 9), result);
    }

    @Test
    void alreadyUniqueAndSorted() {
        assertEquals(
            List.of(1, 2, 3),
            StreamExercises.uniqueSorted(List.of(1, 2, 3))
        );
    }

    @Test
    void emptyListReturnsEmpty() {
        assertEquals(List.of(), StreamExercises.uniqueSorted(List.of()));
    }
}
