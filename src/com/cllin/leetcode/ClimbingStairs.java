package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Source: http://oj.leetcode.com/problems/climbing-stairs/
 */

public class ClimbingStairs implements LeetCodeExercise {
	private int levels;
	
	@Override
	public void initialize() {
		
	}

	@Override
	public void run() {
		for (levels = 0; levels <= 50; levels++) {
			int count = climbStairs(levels);
			System.out.printf("There are %d ways to climb a %d-level letter%n", count, levels);
		}
		
	}
	
	/*
	 * In fact, the n-th Fibonacci number is the solution.
	 * There is a way to compute Fibonacci sequence in constant extra space.
	 */
	private int climbStairs(int n) {
		if (n <= 2) return (n < 0)? 0 : n;
		
		int result = 0;
		int last = 2;
		int lastTwo = 1;
		for (int i = 3; i <= n; i++) {
			result = last + lastTwo;
			lastTwo = last;
			last = result;
		}

		return result;
    }

	@Override
	public boolean test() {
		return false;
	}

}
