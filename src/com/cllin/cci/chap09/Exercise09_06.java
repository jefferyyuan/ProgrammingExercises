package com.cllin.cci.chap09;

import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Given a matrix in which each row and each column is sorted, write a method to find an element in it.
 */

public class Exercise09_06 extends Exercise {
    private final int ROW = 100;
    private final int COLUMN = 100;
    private final int SIZE = ROW * COLUMN;
    private final int MAXIMUM = 10000;
    
    private int[] reference;
    private int[][] matrix;
    
    private static int find(int[][] matrix, int target){
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        
        int row = -1;
        int i, j, k;
        
        i = 0;
        j = nRows - 1;
        while (i <= j) {
            k = (i + j) / 2;
            
            if (matrix[k][0] == target) return k * nCols;
            if (k < nRows - 1 && (matrix[k][0] < target && target < matrix[k + 1][0])) {
                row = k;
                break;
            }
            
            if (matrix[k][0] < target) {
                i = k + 1;
            } else if (matrix[k][0] > target) {
                j = k - 1;
            } 
        }
        
        if (row == -1) return -1;
        
        i = 0;
        j = nCols - 1;
        while (i <= j) {
            k = (i + j) / 2;
            
            if (matrix[row][k] == target) return row * nCols + k;
            
            if (matrix[row][k] < target) {
                i = k + 1;
            } else if (matrix[row][k] > target) {
                j = k - 1;
            }
        }
        
        return -1;
    }
    
    private static int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target)
                return i;
        }

        return -1;
    }

    @Override
    protected void initialize(){
        reference = new int[SIZE];
        matrix = new int[ROW][COLUMN];
        
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        for (int i = 0; i < reference.length; i++) {
            reference[i] = (int)(Math.random() * MAXIMUM);
        }
        
        Arrays.sort(reference);
        
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                matrix[i][j] = reference[i * ROW + j];
            }
        }
    }

    @Override
    protected void runExercise() {
        for (int i = 0; i < 10; i++) {
            int target = (int) (Math.random() * MAXIMUM);

            int key = find(matrix, target);
            int ref = search(reference, target);

            if (key == -1 && ref == -1) {
                System.out.println(target
                        + " does not exist in the matrix, success!");
            } else if (key != -1 && ref != -1) {
                int col = key % ROW;
                int row = (key - col) / ROW;
                System.out.println(target + " is found at (" + row + "," + col
                        + "), success");
            } else {
                System.out.println("Failed");
            }
        }
    }

    @Override
    protected boolean test() {
        return true;
    }
}
