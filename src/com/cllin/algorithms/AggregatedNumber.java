package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * Define a number as an "aggregated number" if this number has the attribute just like the Fibonacci numbers:
 * The digits in the number can divided into several parts, and the later part is the sum of the former parts. 
 * 
 * For example, 
 * 112358, because 1+1=2, 1+2=3, 2+3=5, 3+5=8
 * 122436, because 12+24=36
 * 1299111210, because 12+99=111, 99+111=210
 * 112112224, because 112+112=224
 * 
 * Provide a function to check whether this number is aggregated number or not.
 * 
 * Source: http://www.careercup.com/question?id=14948278
 */

public class AggregatedNumber implements Exercise {

	private final int[] testSuite = {
			112358,
			122436,
			1299111210,
			112112224
	};
	
	@Override
	public void runExercise() {
		for (int n : testSuite) {
			System.out.printf("%d %s an aggregated number%n", n, (isAggregatedNumber(n))? "is" : "is not");
		}
	}
	
	private boolean isAggregatedNumber(int n) {
		String string = Integer.toString(n, 10);
		
		for (int i = 1; i < string.length(); i++) {
			for (int j = i + 1; j < string.length(); j++) {
				if (isMatch(string, i, j)) return true;
			}
		}
		
		return false;
	}
	
	private boolean isMatch(String string, int i, int j) {
		String first = string.substring(0, i);
		String second = string.substring(i, j);
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(first).append(second);
		
		while (buffer.length() < string.length()) {
			String third = Integer.toString(Integer.parseInt(first) + Integer.parseInt(second), 10);
			
			buffer.append(third);
			if (buffer.length() > string.length() || !string.substring(0, buffer.length()).equals(buffer.toString())) {
				return false;
			}
			
			first = second;
			second = third;
		}
		
		return true;
	}

}
