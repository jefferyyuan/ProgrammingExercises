package com.cllin.leetcode;

import java.util.ArrayList;

public class LengthOfLastWord implements LeetCodeExercise {
	private static final String[] testSuite = {"", " ", "   ","a ", " a", "  a  bc  ", "laptop", "hello world ", "how do you do?"};
	
	private int idx;
	private int result;

	@Override
	public void initialize() {
		idx = 0;
		result = 0;
	}

	@Override
	public void runExercise() {
		initialize();
		for (idx = 0; idx < testSuite.length; idx++) {
			result = lengthOfLastWord(testSuite[idx]);
			test();
		}
	}
	
    private int lengthOfLastWord(String string) {
    	int length = string.length();
    	if (length == 0) return 0;

    	ArrayList<Integer> isNotSpace = new ArrayList<Integer>();
    	for (int i = 0; i < length; i++) {
    		if (string.charAt(i) != ' ') isNotSpace.add(i);
    	}
    	
    	int notSpaces = isNotSpace.size();
    	int count = 1;
    	
    	if (notSpaces == 0) return 0;
    	for (int i = notSpaces - 1; i >= 0; i--) {
    		if (i >= 1 && isNotSpace.get(i - 1) == (isNotSpace.get(i) - 1)) count++;
    		else break;
    		
    		if (i == 0 && isNotSpace.get(i) == 0) count++;
    	}
    	
    	return count;
    }

	@Override
	public boolean test() {
		System.out.printf("The length of the last word of -%s- is %d%n", testSuite[idx], result);
		return false;
	}

}
