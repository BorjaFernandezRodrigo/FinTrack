package com.desenrola.katas;

public record Point(double x, double y) {
    public Double distanceTo(Point origin) {
        double dx = this.x - origin.x;
        double dy = this.y - origin.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
