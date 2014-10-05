package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Implement pow(x, n).
 * 
 * Source: http://oj.leetcode.com/problems/powx-n/
 */

public class Power implements LeetCodeExercise {
	private final int MAXIMUM = 10;
	
	private double result;
	private double x;
	private int n;

	@Override
	public void initialize() {
		result = 0;
		x = Math.random() * MAXIMUM;
		n = (MAXIMUM / 2) - (int) (Math.random() * MAXIMUM);
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			initialize();
			result = pow(1.00001, 123456);
			
			if (test()) System.out.println("Success");
			else System.out.println("Failed");
		}
	}
	
	private double pow(double x, int n) {
		if (n == 0) return 1;
		if (x == 0) return 0;
		
		double squareRoot = (n > 0)? pow(x, n / 2) : (1 / pow(x, n * (-1) / 2));
		
		if (n % 2 == 0) return squareRoot * squareRoot;
		else {
			return (n > 0)? squareRoot * squareRoot * x : squareRoot * squareRoot / x;
		}
    }

	@Override
	public boolean test() {
		return ((int) result == (int) Math.pow(x, n));
	}

}
