package com.cllin.leetcode;

public class RegularExpressionMatching implements LeetCodeExercise {

	private TestCase[] testSuite = {
			new TestCase("aa", "a"),
			new TestCase("aa", "aa"),
			new TestCase("aa", "aaa"),
			new TestCase("aa", "a*"),
			new TestCase("aa", ".*"),
			new TestCase("aab", "c*a*b"),
			new TestCase("aaa", "ab*ac*a"),
			new TestCase("b", "c*bb"),
			new TestCase("aaa", "ab*a"),
			new TestCase("aaa", "a*a")
	};
	
	private int index;
	private boolean isMatch;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			TestCase test = testSuite[index];
			isMatch = isMatch(test.s, test.p);
			
			test();
		}
	}
	
	private boolean isMatch(String s, String p) {
		if (s == null) return (p == null);
		if (p.length() == 0) return (s.length() == 0);
		
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1) return false;
			if (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)) return false;
			
			return isMatch(s.substring(1), p.substring(1));
		}
		
		int length = s.length();
		int index = -1;
		
		while (index < length && (index < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(index))) {
			if (isMatch(s.substring(index + 1), p.substring(2))) return true;
			
			index++;
		}
		
		return false;
	}
	
	@Override
	public boolean test() {
		TestCase test = testSuite[index];
		System.out.printf("%s %s %s%n", test.p, (isMatch)? "matches" : "does not match", test.s);
		
		return true;
	}
	
	private class TestCase {
		String s;
		String p;
		TestCase(String s, String p) {
			this.s = s;
			this.p = p;
		}
	}

}
