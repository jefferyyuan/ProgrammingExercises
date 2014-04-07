package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * A robot is located at the top-left corner of a m x n grid.
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid.
 * 
 * How many possible unique paths are there?
 * 
 * Source: http://oj.leetcode.com/problems/unique-paths/
 */

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
