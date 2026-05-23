package com.desenrola.katas;

public interface Shape {
    abstract double area();
    abstract double perimeter();

    default String describe() {
        return String.format(
            "Area: %.2f and Perimeter: %.2f",
            area(),
            perimeter()
        );
    }
}
