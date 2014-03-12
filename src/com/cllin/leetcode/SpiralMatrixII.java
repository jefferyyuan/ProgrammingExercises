package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class SpiralMatrixII implements LeetCodeExercise {
	private int n;
	private int[][] matrix;
	
	@Override
	public void initialize() {
//		TODO
	}

	@Override
	public void runExercise() {
		for (int i = 0; i <= 5; i++) {
			n = i;
			matrix = generateMatrix(n);
			test();
		}
	}
	
    public int[][] generateMatrix(int n) {
    	if (n <= 0) return new int[0][0]; 
    	
    	int[][] matrix = new int[n][n];
    	
    	int i = 0;
    	int j = n - 1;
    	int k = i;
    	int number = 1;
    	
    	for (; i < j; i++, j--) {
    		for (k = i; k < j; k++) {
    			matrix[i][k] = number;
    			number++;
    		}
    		
    		for (k = i; k < j; k++) {
    			matrix[k][j] = number;
    			number++;
    		}
    		
    		for (k = j; i < k; k--) {
    			matrix[j][k] = number;
    			number++;
    		}
    		
    		for (k = j; i < k; k--) {
    			matrix[k][i] = number;
    			number++;
    		}
    	}
    	
    	if (i == j) matrix[i][j] = number;
    	
    	return matrix;
    }

	@Override
	public boolean test() {
		int length = matrix.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.printf("%d\t", matrix[i][j]);
			}
			System.out.println();
		} 
		System.out.println("------------");
		
		return false;
	}

}
