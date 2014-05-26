package com.cllin.cci.chap01;

import com.cllin.main.Exercise;

/*
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes. 
 * Write a method to rotate the image by 90 degrees. Can you do this in place?
 */

public class Exercise01_06 implements Exercise {
	private final int SIZE = 5;
	private final int MAXIMUM = 1000;
	private int[][] matrix;
	private int[][] reference;
	
	@Override
	public void runExercise() {
		initialize();
		matrix = rotate(matrix);
		test();
	}
	
	private int[][] rotate(int[][] matrix) {
		if (matrix == null) return matrix;
		
//		Mirror the matrix diagonally
		int length = matrix.length;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int buf = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = buf;
			}
		}
		
//		Mirror the matrix horizontally
		int bound = length / 2;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < bound; j++) {
				int buf = matrix[i][j];
				matrix[i][j] = matrix[i][length - j - 1];
				matrix[i][length - j - 1] = buf;
			}
		}
		
		return matrix;
	}
	
	private void test() {
		int length = matrix.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (reference[i][j] != matrix[j][length - i - 1]) {
					System.out.println("Failed");
					return;
				}
			}
		}
		System.out.println("Success!");
	}
	
	private void initialize() {
		matrix = new int[SIZE][SIZE];
		reference = new int[SIZE][SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				int n = (int) (Math.random() * MAXIMUM);
				matrix[i][j] = n;
				reference[i][j] = n;
			}
		}
	}
}
