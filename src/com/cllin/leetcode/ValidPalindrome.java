package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class ValidPalindrome implements LeetCodeExercise {
	
	private final TestCase[] testSuite = {
			new TestCase(new String(), true),
			new TestCase("A man, a plan, a canal: Panama", true),
			new TestCase("race a car", false),
			new TestCase("1a2", false),
			new TestCase("5566", false),
			new TestCase(" ", true)
	};
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (TestCase test : testSuite) {
			if (isPalindrome(test.string) == test.isPalindrome) System.out.println("Success");
			else System.out.println("Failed");
		}
	}
	
	private boolean isPalindrome(String string) {
		if (string == null || string.length() == 0) return true;
		
		string = string.toLowerCase();
		
		int length = string.length();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			char ascii = string.charAt(i);
			if ((48 <= (int) ascii && (int) ascii <= 57) || (97 <= (int) ascii && (int) ascii <= 122)) {
				buffer.append(ascii);
			}
		}
		
		string = buffer.toString();
		length = string.length();
		
		if (length == 0) return true;
		for (int i = 0; i <= length / 2; i++) {
			if (string.charAt(i) != string.charAt(length - 1 - i)) return false;
		}
		
		return true;
    }

	@Override
	public boolean test() {
		return false;
	}
	
	private class TestCase {
		private String string;
		private boolean isPalindrome;
		
		TestCase(String string, boolean isPalindrome) {
			this.string = string;
			this.isPalindrome = isPalindrome;
		}
	}

}
