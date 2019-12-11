package com.github.lleuad0.abbyydevcourse;

import java.text.MessageFormat;

public class Point {

    private final int x;
    private final int y;

    public Point() {
        x = 0;
        y = 0;
    }

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

    @Override
    public String toString() {
        {
            return MessageFormat.format("({0},{1})", x, y);
        }
    }
}
