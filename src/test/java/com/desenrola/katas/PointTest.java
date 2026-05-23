package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

// Test
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void recordHasCorrectFields() {
        Point p = new Point(3.0, 4.0);
        assertEquals(3.0, p.x());
        assertEquals(4.0, p.y());
    }

    @Test
    void distanceToOriginIs5() {
        Point origin = new Point(0, 0);
        Point p = new Point(3, 4);
        assertEquals(5.0, p.distanceTo(origin), 0.0001);
    }

    @Test
    void distanceBetweenSamePointIsZero() {
        Point p = new Point(7, 7);
        assertEquals(0.0, p.distanceTo(p), 0.0001);
    }
}
