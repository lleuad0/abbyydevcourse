package com.github.lleuad0.abbyydevcourse;

import java.util.Random;

class Array {
    private Random random;
    private int[][] array;
    private final int rows;
    private final int columns;

    public Array(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        array = new int[rows][columns];
        random = new Random();

        // заполнение массива
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.append(array[i][j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    // метод для одномерного массива, который ставит наибольший элемент на первое место
    private void biggestFirst(int[] elements) {
        // элементы массива сравниваются с первым, поэтому цикл начинается со второго
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > elements[0]) {
                int temp = elements[0];
                elements[0] = elements[i];
                elements[i] = temp;
            }
        }
    }

    public void reformArray() {
        for (int i = 0; i < rows; i++) {
            biggestFirst(array[i]);
        }
    }
}
