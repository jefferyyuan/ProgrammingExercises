package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Source: http://oj.leetcode.com/problems/minimum-path-sum/
 */

public class MinimumPathSum implements LeetCodeExercise {
	private final int MAXIMUM = 10;
	
	private int size_x;
	private int size_y;
	private int result; 
	private int[][] grid;

	@Override
	public void initialize() {
		result = -1;
		grid = new int[size_x][size_y];
		
		for (int i = 0; i < size_x; i++) {
			for (int j = 0; j < size_y; j++) {
				grid[i][j] = (int)(Math.random() * MAXIMUM);
			}
		}
	}

	@Override
	public void runExercise() {
		size_x = 12;
		size_y = 18;
		initialize();
		
		result = minPathSum(grid);
		
		test();
	}
	
	/*
	 * S(m, n) = minimum path sum from A(0, 0) to A(m, n)
	 * S(m, n) = minimum(S(m - 1, n), S(m, n - 1)) + A(m, n)
	 */
    private static int minPathSum(int[][] grid) {
    	if (grid.length < 1 || grid[0].length < 1) return 0;
    	
    	int m = grid.length;
    	int n = grid[0].length;
    	int[][] sum = new int[m][n];
    	
    	sum[0][0] = grid[0][0];
    	for (int i = 1; i < m; i++) sum[i][0] = sum[i - 1][0] + grid[i][0];
    	for (int j = 1; j < n; j++) sum[0][j] = sum[0][j - 1] + grid[0][j];
    	
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
    		}
    	}
    	
    	return sum[m - 1][n - 1];
    }

	@Override
	public boolean test() {
		System.out.printf("The minimum path sum is %d%n", result);
		return false;
	}

}
