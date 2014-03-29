package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class LongestCommonPrefix implements LeetCodeExercise {
	private static final String[][] testSuite = {
			{"", "apple"}, 
			{"apple", "apartment", "apply"}, 
			{"apple", "apply", "banana"}, 
			{"aa", "a"}};

	private int index;
	private String result;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runExercise() {
		initialize();
		
		for (index = 0; index < testSuite.length; index++) {
			result = longestCommonPrefix(testSuite[index]);
			test();
		}

	}

	private String longestCommonPrefix(String[] strings) {
		String prefix = new String();
		int length = strings.length;
		if (length == 0) return prefix;
		
		prefix = strings[0];
		for (int i = 1; i < length; i++) {
			String s = strings[i];
			int l = s.length();
			
			if (l == 0) return new String();
			for (int p = 0; p < l && p < prefix.length(); p++) {
				if (s.charAt(p) != prefix.charAt(p)) prefix = prefix.substring(0, p);
			}
			
			if (prefix.length() > l) prefix = prefix.substring(0, l);
		}
		
		return prefix;
    }
	
	@Override
	public boolean test() {
		System.out.print("For the set of {");
		for (String string : testSuite[index]) System.out.printf(" -%s-", string);
		System.out.print(" }, ");
		
		System.out.printf("the longest prefix is -%s-%n", result);
		
		return false;
	}

}
