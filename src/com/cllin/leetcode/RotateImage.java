package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class RotateImage implements LeetCodeExercise {
	private final int SIZE = 2;
	private final int MAXIMUM = 10;
	private int[][] matrix;
	private int[][] reference;
	
	@Override
	public void initialize() {
		matrix = new int[SIZE][SIZE];
		reference = new int[SIZE][SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				int n = (int)(Math.random() * MAXIMUM);
				matrix[i][j] = n;
				reference[i][j] = n;
			}
		}
	}

	@Override
	public void runExercise() {
		initialize();
		
		rotate(matrix);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
    public void rotate(int[][] matrix) {
    	if (matrix.length == 0 || matrix[0].length == 0) return;
    	
    	int length = matrix.length;
    	
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (i != j) {
					int buf = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = buf;
				}
			}
		}
		
		int bound = length / 2;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < bound; j++) {
				int buf = matrix[i][j];
				matrix[i][j] = matrix[i][length - j - 1];
				matrix[i][length - j - 1] = buf;
			}
		} 
    }

	@Override
	public boolean test() {
		for (int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++){
				if (reference[i][j] != matrix[j][SIZE - i - 1]) return false;
			}
		}
		return true;
	}

}
