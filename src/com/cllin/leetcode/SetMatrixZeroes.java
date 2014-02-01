package com.cllin.leetcode;

public class SetMatrixZeroes implements LeetCodeExercise {
	private final int MAXIMUM = 5;
	private final int SIZE_X = 10;
	private final int SIZE_Y = 1;
	
	private int[][] matrix;
	
	@Override
	public void initialize() {
		matrix = new int[SIZE_X][SIZE_Y];
		
		for (int i = 0; i < SIZE_X; i++) {
			for (int j = 0; j < SIZE_Y; j++) {
				matrix[i][j] = (int)(Math.random() * MAXIMUM);
			}
		}
	}

	@Override
	public void runExercise() {
		initialize();
		setZeroes(matrix);
		
		test();
	}
	
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

	@Override
	public boolean test() {
		System.out.println("Finished");
		return false;
	}

}
