package com.desenrola.katas;

import static org.junit.jupiter.api.Assertions.*;

// Test
import org.junit.jupiter.api.Test;

class ShapeTest {

    @Test
    void circleArea() {
        Shape c = new Circle(5);
        assertEquals(Math.PI * 25, c.area(), 0.0001);
    }

    @Test
    void rectanglePerimeter() {
        Shape r = new Rectangle(3, 4);
        assertEquals(14.0, r.perimeter(), 0.0001);
    }

    @Test
    void defaultDescribeMethod() {
        Shape r = new Rectangle(3, 4);
        assertTrue(r.describe().startsWith("Area:"));
        assertTrue(r.describe().contains("Perimeter:"));
    }
}
