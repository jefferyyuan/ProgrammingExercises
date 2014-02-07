package com.cllin.leetcode;


public class UniquePathsII implements LeetCodeExercise {
	private final int[][][] testSuite = new int[][][]{
			{{1, 0}},
			{{0, 0}, {0, 0}},
			{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
			{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}},
			{{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0} ,{0, 0, 1, 0}, {0, 0, 0, 0}},
			{{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0} ,{0, 0, 1, 0}, {0, 0, 1, 0}}
			};
	
	private int index;
	private int result;

	@Override
	public void initialize() {
		result = 0;
	}

	@Override
	public void runExercise() {
		initialize();
		for (index = 0; index < testSuite.length; index++) {
			result = uniquePathsWithObstacles(testSuite[index]);
			test();
		}
	}
	
    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	int[][] paths = new int[m][n];
    	
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (obstacleGrid[i][j] == 1) paths[i][j] = 0;
    			else if (i == 0 && j == 0) paths[i][j] = 1;
    			else if (i == 0) paths[i][j] = paths[i][j - 1];
    			else if (j == 0) paths[i][j] = paths[i - 1][j];
    			else paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
    		}
    	}
    	
    	return paths[m - 1][n - 1];
    }

	@Override
	public boolean test() {
		int[][] grid = testSuite[index];
		int m = grid.length;
		int n = grid[0].length;
		
		System.out.printf("There are %d unique paths for this grid%n", result);
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%d ", grid[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("------------");
		return false;
	}
}
