package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class WildcardMatching implements LeetCodeExercise {

	private final TestCase[] testSuite = {
			new TestCase("babbba", "*bb?b*?"),
			new TestCase("ba", "*?b??"),
			new TestCase("abcd", "abc*d"),
			new TestCase("hello", "*o*"),
			new TestCase("cabab", "*ab"),
			new TestCase("abce", "abc*??"),
			new TestCase("a", ""),
			new TestCase("a", "aa"),
			new TestCase("a", "a*"),
			new TestCase("aa", "a"),
			new TestCase("aa", "aa"),
			new TestCase("aaa", "aa"),
			new TestCase("aa", "*"),
			new TestCase("aa", "a*"),
			new TestCase("ab", "?*"),
			new TestCase("aab", "c*a*b"),
			new TestCase("abcdef", "a?c*f"),
			new TestCase("aaaaaa", "*a"),
			new TestCase("hi", "*?"),
			new TestCase("c", "*?*"),
			new TestCase("b", "*?*?"),
			new TestCase("", "*a*"),
			new TestCase("", "**"),
			new TestCase("ba", "*a*"),
			new TestCase("ab", "*a"),
			new TestCase("mississippi", "m*si*"),
			new TestCase("mississippi", "m*issip*")
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
		if (s.length() == 0 && p.length() == 0) return true;
		if (p == null || p.length() == 0) return false; 
		
		int sLength = s.length();
		int pLength = p.length();
		
		int i = 0;
		int j = 0;
		
		boolean hasStar = false;
		int afterStarI =Integer.MAX_VALUE;
		int afterStarJ =Integer.MAX_VALUE;
		
		while (j < sLength) {
			if (i == pLength) return false;
			
			if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) {
				i++;
				j++;
			} else if (p.charAt(i) == '*') {
				hasStar = true;
				while (i < pLength && p.charAt(i) == '*') {
					i++;
				}
				
				if (i == pLength) return true;
				if (!p.substring(i).contains("*")) {
					if (sLength - j < pLength - i) return false;
					
					j = sLength - (pLength - i);
				}
				
				afterStarI = i;
				afterStarJ = j;
			} else if (hasStar) {
				i = afterStarI;
				j = ++afterStarJ;
			} else { 
				return false;
			}
		}
		
		while (i < pLength) {
			if (p.charAt(i) != '*') return false;
			i++;
		}
		
    	return true;
    }
	
	@Override
	public boolean test() {
		TestCase test = testSuite[index];
		System.out.printf("'%s' %s '%s'%n", test.p, (isMatch)? "matches" : "doesn't match", test.s);
		
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
