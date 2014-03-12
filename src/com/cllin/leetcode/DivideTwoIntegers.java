package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class DivideTwoIntegers implements LeetCodeExercise {

	private final int MAXIMUM = 100;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (int i = 0; i < 10; i++) {
			int dividend = (int) (Math.random() * MAXIMUM * 10) - MAXIMUM * 10 / 2;
			int divisor = (int) (Math.random() * MAXIMUM) - MAXIMUM / 2;
			
			int quotient = divide(dividend, divisor);
			
			System.out.printf("%s / %s = %s%n", dividend, divisor, quotient);
		}
	}
	
	private int divide(int dividend, int divisor) {
		if (divisor == 0) return Integer.MAX_VALUE;
		if (dividend == 0) return 0;
		
		boolean timeMinusOne = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0));
		
		long a = (long) Math.abs((double) dividend);
		long b = (long) Math.abs((double) divisor);
		
		if (divisor == 1) return (timeMinusOne)? (int) (0 - a) : (int) a;
		if (a == b) return (timeMinusOne)? -1 : 1;
		if (a < b) return 0; 

		int quotient = 0;
		while (a >= b) {
			long q = b;

			for (int count = 1; a >= q; q += q, count += count) {
				a -= q;
				quotient += count;
			}
		}
		
		return (timeMinusOne)? 0 - quotient : quotient;
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}