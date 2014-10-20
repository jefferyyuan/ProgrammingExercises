package com.cllin.cci.chap01;

import com.cllin.main.Exercise;

/*
 * Write an algorithm such that if an element in an M x N matrix is 0, its entire row and column is set to 0.
 */

public class Exercise01_07 extends Exercise {
    private final int SIZE_M = 10;
    private final int SIZE_N = 5;
    private int[][] matrix;
    
    @Override
    protected void initialize() {
        matrix = new int[SIZE_M][SIZE_N];
        for (int i = 0; i < SIZE_M; i++) {
            for (int j = 0; j < SIZE_N; j++) {
                matrix[i][j] = getRandomNumber();
            }
        }
        
        System.out.println("Input matrix:");
        printMatrix();
    }

    @Override
    protected void runExercise() {
    setZeroes(matrix);        
    }

    @Override
    protected boolean test() {
        System.out.println("Result:");
        printMatrix();

        return true;
    }

    /*
     * Use the first row and column to store whether this row/column should be set to zero.
     * Before that, store whether the first row/column should be set to zero.
     * 
     * Add a buffer for the first row and the first column if you want to restore them.
     */
    private void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        
        if (firstRowHasZero) {
            for (int j = 0; j < cols; j++) matrix[0][j] = 0;
        }
        
        if (firstColumnHasZero) {
            for (int i = 0; i < rows; i++) matrix[i][0] = 0;
        }
    }
    
    private void printMatrix() {
        for (int i = 0; i < SIZE_M; i++) {
            for (int j = 0; j < SIZE_N; j++) {
            System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    private static int getRandomNumber() {
        return (Math.random() < 0.3)? 0 : 1;
    }

}
