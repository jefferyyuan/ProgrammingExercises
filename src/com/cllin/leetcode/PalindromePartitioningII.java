package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * Source: http://oj.leetcode.com/problems/palindrome-partitioning-ii/
 */

public class PalindromePartitioningII implements LeetCodeExercise {

	private final String[] testSuite = {
			"aab",
			"ababbbabbaba",
			"eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj",
			"banana"
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
	
	/*
	 * D(i) = minimum number partitions S(i, n) needs
	 * S(i, j) = true if S(i, j) is palindrome
	 * S(i, j) is a palindrome if:
	 * 		1) S(i) == S(j) AND
	 * 		2) S(i + 1, j - 1) is palindrome OR j == i OR j == i + 1
	 * 
	 * If S(i, j) is palindrome,
	 * D(i) = Minimum(D(i), D(j + 1) + 1)
	 */
	private static int minCut(String string) {
		if (string == null || string.length() <= 1) return 0;

		int length = string.length();
		int[] partition = new int[length + 1];
		boolean[][] isPalindrome = new boolean[length][length]; 
		
//		Naive cut
		for (int i = 0; i < length + 1; i++) {
			partition[i] = length - i;
		}
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				isPalindrome[i][j] = false;
			}
		}
		
		for (int i = length - 1; i >= 0; i--) {
			for (int j = i; j < length; j++) {
				if (string.charAt(i) == string.charAt(j) && (j <= i + 1 || isPalindrome[i + 1][j - 1])) {
					isPalindrome[i][j] = true;
					partition[i] = Math.min(partition[i], partition[j + 1] + 1);
				}
			}
		}
		
//		1 partition requires 0 cut, 2 partitions require 1 cut, etc.
    	return partition[0] - 1;
    }

	@Override
	public boolean test() {
		System.out.printf("The minimum cuts needed for a palindrome partitioning of { %s } is %d%n", testSuite[index], nCuts);
		return true;
	}

}
