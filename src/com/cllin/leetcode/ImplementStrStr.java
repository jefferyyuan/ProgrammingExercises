package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class ImplementStrStr implements LeetCodeExercise {

	private TestCase[] testSuite = {
		new TestCase("", ""),
		new TestCase("", "apple"),
		new TestCase("apple", ""),
		new TestCase("This is a simple string", "simple")
	};
	
	private int index;
	private String subString;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			TestCase test = testSuite[index];
			subString = strStr(test.haystack, test.needle);
			
			test();
		}
	}
	
	private String strStr(String haystack, String needle) {
		if (haystack == null) return null;
		if (haystack.length() == needle.length() && haystack.equals(needle)) return haystack;
		if (needle.length() == 0) return haystack;
		
		int hayLength = haystack.length();
		int needleLength = needle.length();
		
		for (int i = 0; i < hayLength - needleLength; i++) {
			int j = i;
			boolean flag = true;
			for (j = 0; j < needleLength; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					flag = false;
					break;
				}
			}
			
			if (flag) return haystack.substring(i);
		}
		
		return null;
    }

	@Override
	public boolean test() {
		if (subString == null) System.out.println("null");
		else System.out.println(subString);
		
		return true;
	}

	private class TestCase {
		String haystack;
		String needle;
		
		TestCase(String haystack, String needle) {
			this.haystack = haystack;
			this.needle = needle;
		}
	}
}
