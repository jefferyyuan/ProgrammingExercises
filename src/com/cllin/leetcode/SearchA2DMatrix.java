package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 		1) Integers in each row are sorted from left to right.
 * 		2) The first integer of each row is greater than the last integer of the previous row.
 * 
 * For example,
 * Consider the following matrix:
 * 		[
 * 		  [1,   3,  5,  7],
 * 		  [10, 11, 16, 20],
 * 		  [23, 30, 34, 50]
 * 		]
 * 
 * Given target = 3, return true.
 * 
 * Source: http://oj.leetcode.com/problems/search-a-2d-matrix/
 */

public class SearchA2DMatrix implements LeetCodeExercise {
	private int MAXIMUM;
	private int SIZE_X;
	private int SIZE_Y;
	
	private int[][] matrix;
	private int[] reference;
	private int target;
	
	private boolean result;

	@Override
	public void initialize() {
		matrix = new int[SIZE_X][SIZE_Y];
		reference = new int[SIZE_X * SIZE_Y];
		
		int index = 0;
		int level = MAXIMUM / SIZE_X;
		int lowerbound = 0;
		for (int i = 0; i < SIZE_X; i++) {
			int[] array = new int[SIZE_Y];
			
			for (int j = 0; j < SIZE_Y; j++) array[j] = (int)(Math.random() * level) + lowerbound;
			Arrays.sort(array);
			
			for (int j = 0; j < SIZE_Y; j++) {
				matrix[i][j] = array[j];
				reference[index] = array[j];
				index++;
			}
			
			lowerbound += level;
		}
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			SIZE_X = 10;
			SIZE_Y = 10;
			MAXIMUM = SIZE_X * SIZE_Y * 1;
			target = (int)(Math.random() * MAXIMUM);
			
			initialize();
			result = searchMatrix(matrix, target);
			
			if (test()) System.out.println("Success");
			else System.out.println("Failed");
		}
		
	}
	
    private boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix.length == 0) return false;
    	
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int x = -1;
    	int y = -1;
    	
    	int start = 0;
    	int end = m - 1;
    	int mid;
    	
    	if (m == 1) {
    		for (int i = 0; i < n; i++) {
    			if (matrix[0][i] == target) return true;
    		}
    		return false;
    	}
    	
    	while (start <= end) {
    		mid = (start + end) / 2;

    		if (mid == m - 1 && matrix[mid][0] < target) {
    			x = mid;
    			break;
    		}
    		
    		if (matrix[mid][0] <= target && target <= matrix[mid + 1][0]) {
    			x = mid;
    			break;
    		}
    		
    		if (target < matrix[mid][0]) {
    			end = mid - 1;
    		} else if (matrix[mid + 1][0] < target) {
    			start = mid + 1;
    		}
    	}
    	
    	if (x == -1) return false;
    	if (matrix[x][0] == target || (x < m - 1 && matrix[x + 1][0] == target)) return true;
    	
    	start = 0;
    	end = n - 1;
    	while (start <= end) {
    		mid = (start + end) / 2;
    		
    		if (target < matrix[x][mid]) {
    			end = mid - 1;
    		} else if (matrix[x][mid] < target) {
    			start = mid + 1;
    		} else {
    			y = mid;
    			break;
    		}
    	}
    	
    	return (y == -1)? false : true;
    }

	@Override
	public boolean test() {
		return (Arrays.binarySearch(reference, target) >= 0) == result;
	}

}
