package com.cllin.chap08;

import java.util.Arrays;

import com.cllin.main.Exercise;

public class Exercise08_01 implements Exercise {
//	Limited by the size of an integer, can be extended by using a long instead
	private final int MAXIMUM = 45;
	private final int[] testSuite = {1, 2, 3, 5, 8, 15, 20, 30, 40, 45};
	private int[] fibonacciNumbers;

	@Override
	public void runExercise() {
		fibonacciNumbers = new int[MAXIMUM + 1];
		Arrays.fill(fibonacciNumbers, -1);
		Arrays.fill(fibonacciNumbers, 0, 3, 1);
		
		for(int n : testSuite){
			int fibonacci = getFibonacciNumber(n);
			System.out.println("The " + n + "th Fibonacci number is " + fibonacci);
		}

	}
	
	private int getFibonacciNumber(int n){
		if (n == 1 || n == 2) return 1;
		if (fibonacciNumbers[n] != -1) return fibonacciNumbers[n];
		
		fibonacciNumbers[n] = getFibonacciNumber(n - 2) + getFibonacciNumber(n - 1);
		
		return fibonacciNumbers[n];
	}

}
