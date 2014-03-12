package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;


public class PalindromePartitioningII implements LeetCodeExercise {

	private final String[] testSuite = {
			"aab",
			"ababbbabbaba",
			"eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj"
	};
	
	private int index;
	private int nCuts;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			nCuts = minCut(testSuite[index]);
			test();
		}
	}
	
	private int minCut(String string) {
		if (string == null || string.length() <= 1) return 0;

		int length = string.length();
		int[] cut = new int[length + 1];
		boolean[][] isPalindrome = new boolean[length][length];
		
		for (int i = 0; i < length + 1; i++) {
			cut[i] = length - i;
		}
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				isPalindrome[i][j] = false;
			}
		}
		
		for (int i = length - 1; i >= 0; i--) {
			for (int j = i; j < length; j++) {
				if (string.charAt(i) == string.charAt(j) && (j - i <= 1 || isPalindrome[i + 1][j - 1])) {
					isPalindrome[i][j] = true;
					cut[i] = Math.min(cut[i], cut[j + 1] + 1);
				}
			}
		}
		
    	return cut[0] - 1;
    }

	@Override
	public boolean test() {
		System.out.printf("The minimum cuts needed for a palindrome partitioning of { %s } is %d%n", testSuite[index], nCuts);
		return true;
	}

}
