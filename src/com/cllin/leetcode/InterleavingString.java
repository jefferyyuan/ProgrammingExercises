package com.cllin.leetcode;

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
		
    	return interleave(s1, s2, s3, true);
    }
	
	private boolean interleave(String s1, String s2, String s3, boolean flag) {
		if (s3.length() != s1.length() + s2.length()) return false;
		
		if (s2.length() == 0) return s3.equals(s1);
		
		if (flag) {
			if (s1.length() == 1) {
				return s3.equals(s1 + s2);
			}
			
			for (int i = 1; i < s1.length(); i++) {
				if (s3.substring(0, i).equals(s1.substring(0, i))) {
					
					if (interleave(s1.substring(i), s2, s3.substring(i), false)) {
						return true;
					}
				}
			}
		} else {
			if (s2.length() == 1) {
				return s3.equals(s2 + s1);
			}
			
			for (int i = 1; i < s2.length(); i++) {
				if (s3.substring(0, i).equals(s2.substring(0, i))) {
					
					if (interleave(s1, s2.substring(i), s3.substring(i), true)) {
						return true;
					}
				}
			}			
		}
		
		return false;
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
