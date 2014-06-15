package com.cllin.cci.chap19;

import com.cllin.main.Exercise;

/*
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 */

public class Exercise19_03 implements Exercise {

	@Override
	public void runExercise() {
		for (int n = 20; n >= 1; n--) {
			long input = getFactorial(n);
			int numOfZeros = getZeros(n); 
			
			if (getReference(input) != getZeros(n)) {
				System.out.println("Failed");
			}

			System.out.printf("%d! = %d, it has %d zeros%n", n, input, numOfZeros);
		}
	}
	
	private static int getReference(long input) {
		int count = 0;
		while (input % 10 == 0) {
			count++;
			input /= 10;
		}
		
		return count;
	}
	
	private static int getZeros(long n) {
		int count = 0;
		
		for (long i = 5; i <= n; i *= 5) {
			count += n / i;
		}
		
		return count;
	}
	
	private static long getFactorial(int input) {
		long factorial = 1;
		for (int i = 1; i < input + 1; i++) {
			factorial *= i;
		}
		
		return factorial;
	}

}
