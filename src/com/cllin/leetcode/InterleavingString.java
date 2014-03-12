package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class InterleavingString implements LeetCodeExercise {

	private final TestCase[] testSuite = {
			new TestCase("aabcc", "dbbca", "aadbbcbcac", true),
			new TestCase("aabcc", "dbbca", "aadbbbaccc", false)
	};
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (int i = 0; i < testSuite.length; i++) {
			TestCase test = testSuite[i];
			
			boolean isInterleave = isInterleave(test.s1, test.s2, test.s3);
			
			if (isInterleave == test.isInterleave) System.out.println("Success");
			else System.out.println("Fail");
		}
	}
	
	private boolean isInterleave(String s1, String s2, String s3) {
		if (s3 == null) return (s1 == null && s2 == null);
		if (s1 == null || s2 == null) {
			if (s1 == null && s2 == null) return s3 == null;
			
			if (s1 == null) return s3.equals(s2);
			if (s2 == null) return s3.equals(s1);
		}
		
		if (s3.length() != s1.length() + s2.length()) return false;
		
		int l1 = s1.length();
		int l2 = s2.length();
		
		boolean[][] table = new boolean[l1 + 1][l2 + 1];
		
		for (int i = 0; i < l1 + 1; i++) {
			for (int j = 0; j < l2 + 1; j++) {
				if (i == 0 || j == 0) {
					if (i == 0 && j == 0) {
						table[i][j] = true;
					} else if (i == 0 && s2.charAt(j - 1) == s3.charAt(j - 1)) {
						table[i][j] = table[i][j - 1];
					} else if (j == 0 && s1.charAt(i - 1) == s3.charAt(i - 1)) {
						table[i][j] = table[i - 1][j];
					} 
				} else {
					if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) != s3.charAt(i + j - 1)) {
						table[i][j] = table[i - 1][j];
					} else if (s1.charAt(i - 1) != s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
						table[i][j] = table[i][j - 1];
					} else if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
						table[i][j] = table[i - 1][j] || table[i][j - 1];
					}
				}
			}
		}
		
    	return table[l1][l2];
    }

	@Override
	public boolean test() {
		return false;
	}
	
	private class TestCase {
		String s1;
		String s2;
		String s3;
		boolean isInterleave;
		
		TestCase(String s1, String s2, String s3, boolean isInterleave) {
			this.s1 = s1;
			this.s2 = s2;
			this.s3 = s3;
			this.isInterleave = isInterleave;
		}
	}

}
