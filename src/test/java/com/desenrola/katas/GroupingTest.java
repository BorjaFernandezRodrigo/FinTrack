package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class GroupingTest {

    @Test
    void groupsByLength() {
        Map<Integer, List<String>> result = GroupingExercises.groupByLength(
            List.of("hi", "hey", "hello", "bye", "ok")
        );
        assertEquals(List.of("hi", "ok"), result.get(2));
        assertTrue(result.get(3).containsAll(List.of("hey", "bye")));
        assertEquals(List.of("hello"), result.get(5));
    }
}
