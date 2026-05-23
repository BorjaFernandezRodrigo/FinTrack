package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
// Test
import org.junit.jupiter.api.Test;

class SumOfSquaresTest {

    @Test
    void sumOfSquaresBasic() {
        assertEquals(14, StreamExercises.sumOfSquares(List.of(1, 2, 3)));
    }

    @Test
    void sumOfSquaresWithZero() {
        assertEquals(0, StreamExercises.sumOfSquares(List.of(0, 0, 0)));
    }

    @Test
    void sumOfSquaresEmptyList() {
        assertEquals(0, StreamExercises.sumOfSquares(List.of()));
    }
}
