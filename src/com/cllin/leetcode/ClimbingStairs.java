package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;


public class ClimbingStairs implements LeetCodeExercise {
	private int levels;
	
	@Override
	public void initialize() {
		
	}

	@Override
	public void runExercise() {
		for (levels = 0; levels <= 50; levels++) {
			int count = climbStairs(levels);
			System.out.printf("There are %d ways to climb a %d-level letter%n", count, levels);
		}
		
	}
	
	private int climbStairs(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		else if (n == 2) return 2;
		
		int result = 0;
		int last = 2;
		int lastOfLast = 1;
		for (int i = 3; i <= n; i++) {
			result = last + lastOfLast;
			lastOfLast = last;
			last = result;
		}

		return result;
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
