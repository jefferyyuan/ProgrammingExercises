package com.cllin.leetcode;

import java.util.Stack;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * Source: http://oj.leetcode.com/problems/longest-valid-parentheses/
 */

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
		
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		int index = 0;
		int last = -1;
		while (index < string.length()) {
			if (string.charAt(index) == '(') {
				stack.push(index);
			} else {
				if (stack.isEmpty()) {
					last = index;
				} else {
					stack.pop();
					max = Math.max(max, stack.isEmpty()? index - last : index - stack.peek());
				}
			}
			
			index++;
		}
		
    	return max;
    }

	@Override
	public boolean test() {
		System.out.printf("The length of longest valid parentheses from %s is %d%n", testSuite[index], lengthOfValidParentheses);
		
		return true;
	}

}
