package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class DistinctSubsequences implements LeetCodeExercise {

	private final TestCase[] testSuite = {
		new TestCase("rabbbit", "rabbit", 3),
		new TestCase("b", "b", 1),
		new TestCase("a", "b", 0)
	};
	
	private int index;
	private int result;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			TestCase test = testSuite[index];
			result = numDistinct(test.S, test.T);
			
			if (test()) System.out.println("Success");
			else System.out.println("Failed");
		}
	}

	private int numDistinct(String S, String T) {
		if (S == null || T == null) return (S == null && T == null)? 1 : 0;
		if (S.length() == 0 || T.length() == 0) return (S.length() == 0 && T.length() == 0)? 1 : 0;
		
		int m = S.length();
		int n = T.length();
		int[][] table = new int[m + 1][n + 1];
		
		for (int i = 0; i <= m; i++) table[i][0] = 1;
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) table[i][j] += table[i - 1][j - 1] + table[i - 1][j];
				else table[i][j] += table[i - 1][j];
			}
		}
		
    	return table[m][n];
    }
	
	@Override
	public boolean test() {
		return (testSuite[index].numDistinctSubsequences == result);
	}

	private class TestCase {
		String S;
		String T;
		int numDistinctSubsequences;
		
		TestCase(String S, String T, int numDistinctSubsequences) {
			this.S = S;
			this.T = T;
			this.numDistinctSubsequences = numDistinctSubsequences;
		}
	}
}
