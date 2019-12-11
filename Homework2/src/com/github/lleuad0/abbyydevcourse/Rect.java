package com.github.lleuad0.abbyydevcourse;

import java.text.MessageFormat;

public class Rect {
    private Point topLeft;
    private Point bottomRight;

    public Rect(Point topLeft, Point bottomRight) {
        if (topLeft.equals(bottomRight)
                || bottomRight.getX() <= topLeft.getX()
                || topLeft.getY() <= bottomRight.getY()) {
            throw new IllegalArgumentException();
        } else {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Прямоугольник с верхней левой точкой {0}, правой нижней точкой {1}",
                topLeft,
                bottomRight);
    }

}
