package com.github.lleuad0.abbyydevcourse;

import java.util.Random;

class Array {
    private Random random;
    private int[][] array;
    private int rows;
    private int columns;

    public Array(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        array = new int[rows][columns];
        random = new Random();

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

    public void sortArray() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 1; j++) {
                for (int k = j; k < columns; k++) {
                    if (array[i][k] > array[i][j]) {
                        int temp = array[i][k];
                        array[i][k] = array[i][j];
                        array[i][j] = temp;
                    }
                }
            }
        }
    }
}
