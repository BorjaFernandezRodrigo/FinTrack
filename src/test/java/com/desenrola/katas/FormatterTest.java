package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
// Test
import org.junit.jupiter.api.Test;

class FormatterTest {

    @Test
    void formatAllUpperCase() {
        assertEquals(
            List.of("JAVA", "ROCKS"),
            Formatter.formatAll(List.of("java", "rocks"))
        );
    }

    @Test
    void parseLongsFromStrings() {
        List<Long> result = Formatter.parseLongs(List.of("100", "200", "300"));
        assertEquals(List.of(100L, 200L, 300L), result);
    }
}
