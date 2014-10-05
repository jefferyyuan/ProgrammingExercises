package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return
 * [
 * 		["aa","b"],
 * 		["a","a","b"]
 * ]
 * 
 * Source: http://oj.leetcode.com/problems/palindrome-partitioning/
 */

public class PalindromePartitioning implements LeetCodeExercise {

	private final String[] testSuite = {
			"",
			"a",
			"aab",
			"uccu",
			"seeslaveidemonstrateyetartsnomedievalsees"
	};
	
	private ArrayList<ArrayList<String>> result;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		int length = testSuite.length;
		for (int i = 0; i < length; i++) {
			result = partition(testSuite[i]);
			test();
		}
	}
	
	private ArrayList<ArrayList<String>> partition(String string) {
		if (string == null || string.length() == 0) return new ArrayList<ArrayList<String>>();
		return getPartitions(string, string.length() - 1);
	}
	
	private ArrayList<ArrayList<String>> getPartitions(String string, int index) {
		ArrayList<ArrayList<String>> partitions = new ArrayList<ArrayList<String>>();
		
		if (index < 0) return partitions;
		
		ArrayList<String> palindromes = getPalindromes(string, index);
		for (String palindrome : palindromes) {
			if (index - palindrome.length() == -1) {
				ArrayList<String> newPartition = new ArrayList<String>();
				newPartition.add(palindrome);
				partitions.add(newPartition);
			} else {
				ArrayList<ArrayList<String>> partition = getPartitions(string, index - palindrome.length());
				for (ArrayList<String> p : partition) {
					ArrayList<String> newPartition = new ArrayList<String>();
					newPartition.addAll(p);
					newPartition.add(palindrome);
					partitions.add(newPartition);
				}
			}
		}
		
		return partitions;
	}
	
//	Get palindromes that end at index
	private ArrayList<String> getPalindromes(String string, int index) {
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for (int i = index; i >= 0; i--) {
			if (isPalindrome(string, i, index)) {
				palindromes.add(string.substring(i, index + 1));
			}
		}
		
		return palindromes;
	}
	
	private boolean isPalindrome(String string, int start, int end) {
		int bound = (end - start + 1) / 2;
		for (int i = 0; i < bound; i++) {
			if (string.charAt(start + i) != string.charAt(end - i)) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean test() {
		for (ArrayList<String> partition : result) {
			for (String subString : partition) System.out.printf("%s ", subString);
			System.out.println();
		}
		System.out.println("------------------");
		return false;
	}

}
