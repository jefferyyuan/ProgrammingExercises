package com.cllin.cci.chap08;

import java.util.ArrayList;

import com.cllin.main.Exercise;

/*
 * Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n-pairs of parentheses.
 * 
 * EXAMPLE:
 * input: 3 (e.g., 3 pairs of parentheses)
 * output: ()()(), ()(()), (())(), ((()))
 */

public class Exercise08_05 implements Exercise {
	private final int[] testSuite = {1, 2, 3, 4, 5};
	
	ArrayList<String> result;
	
	@Override
	public void runExercise() {
		for (int n : testSuite) {
			System.out.println("For " + n + " parenthese,");
			result = getParentheses(n);
			
			for (String string : result) {
				System.out.printf("%s%n", string);
			}
			
			System.out.println("------------------------------");
		}
	}
	
	private static ArrayList<String> getParentheses(int n) {
		return getParenthesesHelper(new ArrayList<String>(), new String(), n, n);
	}
	
	private static ArrayList<String> getParenthesesHelper(ArrayList<String> result, String string, int left, int right) {
		if (left < 0) return result;
		
		if (left == 0 && right == 0) {
			result.add(new String(string));
			return result;
		}
		
		if (left > 0) getParenthesesHelper(result, string + '(', left - 1, right);
		if (right > left) getParenthesesHelper(result, string + ')', left, right - 1);
		
		return result;
	}


}
