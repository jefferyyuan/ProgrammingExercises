package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class LongestValidParentheses implements LeetCodeExercise {

	private final String[] testSuite = {
			"(()",
			")()())",
			"()()))((",
			")()()()()()()))()(()"
	};
	
	private int index;
	private int lengthOfValidParentheses;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			lengthOfValidParentheses = longestValidParentheses(testSuite[index]);
			
			test();
		}
	}
	
	private int longestValidParentheses(String string) {
		if (string == null || string.length() == 0) return 0;
		
		int i = 0;
		int max = 0;
		int count = 0;
		char[] charArray = string.toCharArray();
		while (i < string.length()) {
			if (charArray[i] == ')') {
				for (int j = i - 1; j >= 0; j--) {
					if (charArray[j] == '(') {
						charArray[i] = '*';
						charArray[j] = '*';
						break;
					}
				}
			}
			
			i++;
		}

		i = 0;
		while (i < string.length()) {
			if (charArray[i] == '*') {
				count = 0;
				for (int j = i; j < string.length() && charArray[j] == '*'; j++) {
					count++;
				}
				
				max = Math.max(max, count);
				
				while (i < string.length() && charArray[i] == '*') {
					i++;
				}
			} else {
				i++;
			}
		}
		
    	return max;
    }

	@Override
	public boolean test() {
		System.out.printf("The length of longest valid parentheses from %s is %d%n", testSuite[index], lengthOfValidParentheses);
		
		return true;
	}

}
