package com.github.lleuad0.abbyydevcourse;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /*
    public boolean equals(Object object) {
        boolean result = false;
        if (object instanceof Point) {
            Point point = (Point) object;
            if (x == point.x && y == point.y) {
                result = true;
            }
        }
        return result;
    }

    public int hashcode() {
        return x + y * 31;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
