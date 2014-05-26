package com.cllin.cci.chap01;

import java.util.ArrayList;

import com.cllin.main.Exercise;

/*
 * Write an algorithm such that if an element in an M x N matrix is 0, its entire row and column is set to 0.
 */

public class Exercise01_07 implements Exercise {
	private final int SIZE_M = 10;
	private final int SIZE_N = 5;
	private int[][] matrix;

	@Override
	public void runExercise() {
		initialize();
		setZero(matrix);
	}
	
//	If the content of the matrix is limited to a certain scope, define a symbol to mark elements that should be set to 0
	private void setZero(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return;
		
		ArrayList<Integer> rowsToBeZero = new ArrayList<Integer>();
		ArrayList<Integer> columnsToBeZero = new ArrayList<Integer>();
		
		int nRows = matrix.length;
		int nCols = matrix[0].length;
		
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (matrix[i][j] == 0) {
					rowsToBeZero.add(i);
					columnsToBeZero.add(j);
				}
			}
		}
		
		for (int rows : rowsToBeZero) {
			for (int j = 0; j < nCols; j++) {
				matrix[rows][j] = 0;
			}
		}
		
		for (int cols : columnsToBeZero) {
			for (int i = 0; i < nRows; i++) {
				matrix[i][cols] = 0;
			}
		}
	}
	
	private void initialize() {
		matrix = new int[SIZE_M][SIZE_N];
		for(int i = 0; i < SIZE_M; i++){
			for(int j = 0; j < SIZE_N; j++){
				matrix[i][j] = getRandomNumber();
			}
		}
	}
	
	private int getRandomNumber() {
		return (Math.random() < 0.3)? 0 : 1;
	}

}
