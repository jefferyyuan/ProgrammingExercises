package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 		'A' -> 1
 * 		'B' -> 2
 * 		...
 * 		'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * 
 * Source: http://oj.leetcode.com/problems/decode-ways/
 */

public class DecodeWays implements LeetCodeExercise {

	private final String[] testSuite = {
			"1212",
			"10",
			"12",
			"67",
			"9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253",
			"101",
			"110",
			"111",
			"230",
			"611",
			"023",
			"47159"
	};
	
	private int index;
	private int nWays;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			nWays = numDecodings(testSuite[index]);
			test();
		}
	}
	
	/*
	 * Define:
	 * W(n) = number of ways to decode the string starting (inclusively) from n
	 * V(a, b) = a boolean value that shows if the string between a and b (inclusively) is valid for decoding
	 * 
	 * W(n) = W(n + 1) * V(n, n) + W(n + 2) * V(n, n + 1)
	 * 
	 * W(0) = number of ways to decode the string starting (inclusively) from 0, which is the solution
	 * 
	 * Source: http://oj.leetcode.com/problems/decode-ways/
	 */
	
	private int numDecodings(String string) {
		if (string == null || string.length() == 0) return 0;
		
		int[] table = new int[string.length() + 1];
		table[string.length()] = 1;
		
		for (int i = string.length() - 1; i >= 0; i--) {
			int n = Character.getNumericValue(string.charAt(i));
			
			table[i] = (n > 0)? table[i + 1] : 0;
			
			if (i + 1 < string.length()) {
				int thisTwo = Integer.parseInt(string.substring(i, i + 2));
				if (thisTwo >= 10 && thisTwo <= 26) {
					table[i] += table[i + 2];
				}
			}
		}
		
    	return table[0];
    }

	@Override
	public boolean test() {
		System.out.printf("There are %d ways to decode '%s'%n", nWays, testSuite[index]);
		return true;
	}

}
