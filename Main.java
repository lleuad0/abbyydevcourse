package com.github.lleuad0.abbyydevcourse;

public class Main {

    public static double getDistance(Point a, Point b) {
        double deltaX = b.getX() - a.getX();
        double deltaY = b.getY() - a.getY();

        double xSquared = Math.pow(deltaX, 2);
        double ySquared = Math.pow(deltaY, 2);

        return Math.sqrt(xSquared + ySquared);
    }

    public static void main(String[] args) {
        Point a = new Point(2, 5);
        Point b = new Point(21, 0);

        System.out.println(getDistance(a, b));
    }
}
