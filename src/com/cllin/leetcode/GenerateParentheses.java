package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

public class GenerateParentheses implements LeetCodeExercise {
	
	private ArrayList<String> result;
	
	@Override
	public void initialize() {
		result = new ArrayList<String>();
	}

	@Override
	public void runExercise() {
		initialize();
		test();
	}
	
	
    private ArrayList<String> generateParenthesis(int n) {
    	printParenthese(n, n, new String(), 0);
    	return result;
    }
    
	private void printParenthese(int left, int right, String string, int count){
		if (left < 0 || right < left) return;
		
		if (left == 0 && right == 0) {
			result.add(new String(string));
			return;
		} else {
			if (left > 0) printParenthese(left - 1, right, string + '(', count + 1);
			if (right > left) printParenthese(left, right - 1, string + ')', count + 1);
		}
	}

	@Override
	public boolean test() {
		for (int i = 2; i <= 5; i++) {
			System.out.printf("n = %d%n", i);
			
			ArrayList<String> r = generateParenthesis(i);
			for (String string : r) System.out.printf("%s ", string);
			
			System.out.println("\n------------");
			
			result = new ArrayList<String>();
		}
		
		return false;
	}

}
