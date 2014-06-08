package com.cllin.cci.chap10;

import com.cllin.main.Exercise;

/*
 * Write a method to implement *, - , / operations. You should use only the + operator.
 */

public class Exercise10_04 implements Exercise {

	private static final int MAXIMUM = 1000;
	
	@Override
	public void runExercise() {
		for (int i = 0; i < 1000; i++) {
			int a = (int) (Math.random() * MAXIMUM);
			int b = (int) (Math.random() * MAXIMUM);
			
			if (generateNegative()) a = -a;
			if (generateNegative()) b = -b;
			
			if (a - b != minus(a, b)) {
				System.out.println("Failed, minus");
				return;
			}
			
			if (a * b != time(a, b)) {
				System.out.println("Failed, time");
				return;
			}
			
			if (a / b != divide(a, b)) {
				System.out.println("Failed, divide");
				return;
			}
		}
		
		System.out.println("Success!");
	}
	
	private static int minus(int a, int b) {
		return a + (-b);
	}
	
	private static int time(int a, int b) {
		boolean isNegative = false;
		
		if (a == 0 || b == 0) return 0;
		if (b < 0) {
			isNegative = true;
			b = -b;
		}
		
		int product = 0;
		for (int i = 1; i <= b; i++) {
			product += a;
		}
		
		return (isNegative)? -product : product;
	}
	
	private static int divide(int a, int b) {
		boolean isNegative = false;
		
		if (b == 0) return Integer.MAX_VALUE;
		if (a == 0) return 0;
		if (a < 0 || b < 0) {
			if (!(a < 0 && b < 0)) {
				isNegative = true;
			}
			
			a = Math.abs(a);
			b = Math.abs(b);
		}
		
		int quotient = 0;
		while (a - b >= 0) {
			a -= b;
			quotient++;
		}
		
		return (isNegative)? -quotient : quotient;
	}
	
	private static boolean generateNegative() {
		return Math.random() > 0.5;
	}
}
