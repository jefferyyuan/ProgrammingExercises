package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class ValidParentheses implements LeetCodeExercise {
	private final String[] testSuite = {"", "()[]{}", "([)]{}", "([])"};

	private int index;
	private boolean result;
	
	@Override
	public void initialize() {
		index = 0;
		result = false;
	}

	@Override
	public void runExercise() {
		initialize();
		
		for (int i = 0; i < testSuite.length; i++) {
			result = isValid(testSuite[i]);
			test();
		}
	}
	
    public boolean isValid(String s) {
    	int length = s.length();
    	if (length == 0) return true;
    	if (length % 2 == 1) return false;
    	
    	int lastLength = 0;
    	
    	while (s.length() > 0) {
    		if (lastLength == length) return false; 
    		char[] string = s.toCharArray();
    		
    		for (int i = 0; i < length - 1; i++) {
    			char currentCharacter = string[i];
    			char nextCharacter = string[i + 1];
    			
    			if ((currentCharacter == '(' && nextCharacter == ')') 
    					|| (currentCharacter == '{' && nextCharacter == '}') 
    					|| (currentCharacter == '[' && nextCharacter == ']')) {
    				
    				string[i] = '0';
    				string[i + 1] = '0';
    				
    				i += 2;
    			}
    		}

    		s = new String(string);
    		s = s.replace("0", "");
    		
    		lastLength = length;
    		length = s.length();
    	}
    	
        return true;
    }

	@Override
	public boolean test() {
		if (result) System.out.printf("The parentheses of %s are valid%n", testSuite[index].toString());
		else System.out.printf("The parentheses of %s are not valid%n", testSuite[index].toLowerCase());
		
		return false;
	}

}
