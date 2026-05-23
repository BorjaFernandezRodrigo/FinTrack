package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

// Test
import org.junit.jupiter.api.Test;

class TemperatureTest {

    @Test
    void validTemperatureCreated() {
        Temperature t = new Temperature(100.0);
        assertEquals(100.0, t.celsius());
    }

    @Test
    void belowAbsoluteZeroThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            new Temperature(-300.0)
        );
    }

    @Test
    void boilingPointInFahrenheit() {
        Temperature t = new Temperature(100.0);
        assertEquals(212.0, t.toFahrenheit(), 0.0001);
    }

    @Test
    void freezingPointInFahrenheit() {
        Temperature t = new Temperature(0.0);
        assertEquals(32.0, t.toFahrenheit(), 0.0001);
    }
}
