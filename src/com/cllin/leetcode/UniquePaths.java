package com.cllin.leetcode;

public class UniquePaths implements LeetCodeExercise {
	private final int MAXIMUM = 10;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (int i = 0; i < 10; i++) {
			int m = (int)(Math.random() * MAXIMUM) + 1;
			int n = (int)(Math.random() * MAXIMUM) + 1;
			
			int paths = uniquePaths(m, n);
			System.out.printf("There are %d unique paths to reach another conrner of a %d * %d grid%n", paths, m, n);
		}
	}
	
    @SuppressWarnings("unused")
	private int uniquePathsInRecursive(int m, int n) {
    	return (m == 1 || n == 1)? 1 : uniquePathsInRecursive(m - 1, n) + uniquePathsInRecursive(m, n - 1);
    }
    
    private int uniquePaths(int m, int n) {
    	if (m == 1 || n == 1) return 1;
    	
    	double result = 1;
    	for (int i = 1; i < n; i++) {
    		result /= i;
    		result *= (m + i - 1);
    	}
    	
    	return (int) result;
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
