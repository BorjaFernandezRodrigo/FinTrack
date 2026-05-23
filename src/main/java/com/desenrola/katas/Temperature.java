package com.desenrola.katas;

public record Temperature(double celsius) {
    public Temperature {
        if (celsius < -273.15) {
            throw new IllegalArgumentException(
                "Temperature cannot be below absolute zero"
            );
        }
    }

    public double toFahrenheit() {
        return (celsius * 9.0) / 5.0 + 32.0;
    }
}
