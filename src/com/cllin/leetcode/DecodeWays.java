package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

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
	
	private int numDecodings(String string) {
		if (string == null || string.length() == 0) return 0;
		if (string.length() == 1) {
			int first = Character.getNumericValue(string.charAt(0));
			return (first >= 1 && first <= 26)? 1 : 0;
		}
		
		int[] table = new int[string.length() + 1];
		table[string.length()] = 1;
		for (int i = string.length() - 1; i >= 0; i--) {
			int n = Character.getNumericValue(string.charAt(i));
			
			if (n > 0) {
				table[i] = table[i + 1];
				
				if (i + 1 < string.length()) {
					int thisTwo = Integer.parseInt(string.substring(i, i + 2));
					if (thisTwo >= 10 && thisTwo <= 26) {
						table[i] += table[i + 2];
					}
				}
			} else {
				table[i] = 0;
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
