package com.cllin.leetcode;

import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber implements LeetCodeExercise {
	private String[] testSuite = {"","23", "5566"};
	
	private int index;
	private ArrayList<String> result;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			result = letterCombinations(testSuite[index]);
			
			if (test()) System.out.println("Success");
			else System.out.println("Failed");
		}
	}
	
	private ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> combinations = new ArrayList<String>();
		if (digits.length() == 0) {
//			It is required to have a null String to pass the test cases of LeetCode ):
			combinations.add(new String());
			return combinations;
		}

		int thisLevel = 0;
		int previousLevel = 0;
		int length = digits.length();
		for (int i = 0; i < length; i++) {
			int size = combinations.size();
			int digit = Character.getNumericValue(digits.charAt(i));
			char[] characters = getCharacters(digit);
			
			if (size == 0) {
				for (char c : characters) {
					combinations.add(String.valueOf(c));
					thisLevel++;
				}
			} else {
				for (int j = size - previousLevel; j < size; j++) {
					for (char c : characters) {
						StringBuffer newCombination = new StringBuffer(combinations.get(j));
						newCombination.append(c);
						combinations.add(newCombination.toString());
						thisLevel++;
					}
				}
			}
			
			previousLevel = thisLevel;
			thisLevel = 0;
		}
		
		int size = combinations.size();
		ArrayList<String> output = new ArrayList<String>();
		for (int i = size - previousLevel; i < size; i++) {
			output.add(combinations.get(i));
		}
		
		return output;
    }
	
	private static char[] getCharacters(int digit) {
		switch (digit) {
		case 2:
			return new char[]{'a', 'b', 'c'};
		case 3:
			return new char[]{'d', 'e', 'f'};
		case 4:
			return new char[]{'g', 'h', 'i'};
		case 5:
			return new char[]{'j', 'k', 'l'};
		case 6:
			return new char[]{'m', 'n', 'o'};
		case 7:
			return new char[]{'p', 'q', 'r', 's'};
		case 8:
			return new char[]{'t', 'u', 'v'};
		case 9:
			return new char[]{'w', 'x', 'y', 'z'};
			default:
				return new char[4];
			
		}
	}

	@Override
	public boolean test() {
		int result = 1;
		String input = testSuite[index];
		
		if (input.length() == 0) result = 1;
		else {
			for (char c : input.toCharArray()) {
				int digit  = Character.getNumericValue(c);
				if (digit < 7 || digit == 8) result *= 3;
				else result *= 4;
			}
		}
		
		return (this.result.size() == result);
	}

}
