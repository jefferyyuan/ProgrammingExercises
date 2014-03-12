package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;


public class MinimumWindowSubstring implements LeetCodeExercise {

	private final TestCase[] testSuite = {
			new TestCase("ADOBECODEBANC", "ABC")
	};
	
	private int index;
	private String window;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			TestCase test = testSuite[index];
			window = minWindow(test.S, test.T);
			
			test();
		}
	}
	
	private String minWindow(String S, String T) {
		if (S == null || S.length() == 0 || T == null || T.length() == 0) return new String();
		if (T.length() > S.length()) return new String();
		
		int sLength = S.length();
		int tLength = T.length();
		int minimumWindowLength = Integer.MAX_VALUE;
		int minimumWindowBegin = 0;
		int minimumWindowEnd = 0;
		
//		Build a table that stores the number of each characters t has
		int[] needToFind = new int[128];
		Arrays.fill(needToFind, 0);
		for (int i = 0; i < tLength; i++) {
			needToFind[T.charAt(i)]++;
		}

//		Build a table that stores the number of each characters the current window has
		int[] hasFound = new int[128];
		Arrays.fill(hasFound, 0);
		
		int length = 0;
		for (int begin = 0, end = 0; end < sLength; end++) {
			char c = S.charAt(end);
			if (needToFind[(int) c] != 0) {
				hasFound[(int) c]++;
				
//				Maintain the flag that indicates whether the constraint is reached
				if (hasFound[(int) c] <= needToFind[(int) c]) {
					length++;
				}

//				If the constraint is reached
				if (length == tLength) {
					
//					Trim current window by removing unneeded characters (from the beginning)
					while (needToFind[(int) S.charAt(begin)] == 0 || 
							hasFound[(int) S.charAt(begin)] > needToFind[(int) S.charAt(begin)]) {
						if (hasFound[(int) S.charAt(begin)] > needToFind[(int) S.charAt(begin)]) {
							hasFound[(int) S.charAt(begin)]--;
						}
						begin++;
					}

//					Update the minimum window if needed
					int windowLength = end - begin + 1;
					if (windowLength < minimumWindowLength) {
						minimumWindowLength = windowLength;
						minimumWindowBegin = begin;
						minimumWindowEnd = end;
					}
				}
			}
		}
		
    	return (minimumWindowLength == Integer.MAX_VALUE)? new String() : S.substring(minimumWindowBegin, minimumWindowEnd + 1);
    }

	@Override
	public boolean test() {
		TestCase test = testSuite[index];
		System.out.printf("The minimum window of { %s } that contains characters from { %s } is { %s }%n", test.S, test.T, window);
		
		return true;
	}
	
	private class TestCase {
		String S;
		String T;
		TestCase(String S, String T) {
			this.S = S;
			this.T = T;
		}
	}

}
