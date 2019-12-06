package com.github.lleuad0.abbyydevcourse;

public class Main {

    public static void main(String[] args) {
        //часть 1, про массив
        Array array = new Array(6, 7);
        System.out.println("Исходный массив\n" + array);
        array.reformArray();
        System.out.println("Преобразованный массив\n" + array);

        //часть 2, про точки и прямоугольники
        Point p1 = new Point(-2, 5);
        Point p2 = new Point();
        Rect rect = new Rect(p1, p2);
        System.out.println(rect);

        System.out.println("Ширина " + Util.getRectWidth(rect));
        System.out.println("Высота " + Util.getRectHeight(rect));
        System.out.println("Площадь " + Util.getRectSquare(rect));
        System.out.println("Периметр " + Util.getRectPerimeter(rect));

    }
}
