package com.cllin.leetcode;

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
	
    private int minPathSum(int[][] grid) {
    	if (grid.length < 1 || grid[0].length < 1) return 0;
    	
    	int m = grid.length;
    	int n = grid[0].length;
    	int[][] minimum = new int[m][n];
    	
    	minimum[0][0] = grid[0][0];
    	for (int i = 1; i < m; i++) minimum[i][0] = minimum[i - 1][0] + grid[i][0];
    	for (int i = 1; i < n; i++) minimum[0][i] = minimum[0][i - 1] + grid[0][i];
    	
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			minimum[i][j] = Math.min(minimum[i - 1][j], minimum[i][j - 1]) + grid[i][j];
    		}
    	}
    	
    	return minimum[m - 1][n - 1];
    }

	@Override
	public boolean test() {
		System.out.printf("The minimum path sum is %d%n", result);
		return false;
	}

}
