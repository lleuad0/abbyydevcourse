package com.github.lleuad0.abbyydevcourse;

public class Util {
    private Util() {
    }

    static int getRectWidth(Rect rect) {
        Point topLeft = rect.getTopLeft();
        Point bottomRight = rect.getBottomRight();
        return bottomRight.getX() - topLeft.getX();
    }

    static int getRectHeight(Rect rect) {
        Point topLeft = rect.getTopLeft();
        Point bottomRight = rect.getBottomRight();
        return topLeft.getY() - bottomRight.getY();
    }

    static int getRectSquare(Rect rect) {
        return getRectWidth(rect) * getRectHeight(rect);
    }

    //в условии д/з сказано про три метода, но иметь площадь и не иметь периметра - это странно
    static int getRectPerimeter(Rect rect) {
        return (getRectHeight(rect) + getRectWidth(rect)) * 2;
    }

}
