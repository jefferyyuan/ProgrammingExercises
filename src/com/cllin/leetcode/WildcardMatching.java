package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Examples:
 * isMatch("aa","a") 		-> false
 * isMatch("aa","aa") 		-> true
 * isMatch("aaa","aa") 		-> false
 * isMatch("aa", "*") 		-> true
 * isMatch("aa", "a*") 		-> true
 * isMatch("ab", "?*") 		-> true
 * isMatch("aab", "c*a*b") 	-> false
 * 
 * Source: http://oj.leetcode.com/problems/wildcard-matching/
 */

public class WildcardMatching implements LeetCodeExercise {

	private final TestCase[] testSuite = {
			new TestCase("b", "*a*"),
			new TestCase("aa", "*"),
			new TestCase("aa", "a"),
			new TestCase("babbba", "*bb?b*?"),
			new TestCase("ba", "*?b??"),
			new TestCase("abcd", "abc*d"),
			new TestCase("hello", "*o*"),
			new TestCase("cabab", "*ab"),
			new TestCase("abce", "abc*??"),
			new TestCase("a", ""),
			new TestCase("a", "aa"),
			new TestCase("a", "a*"),
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
	public void run() {
		for (index = 0; index < testSuite.length; index++) {
			TestCase test = testSuite[index];
			isMatch = isMatch(test.s, test.p);
			
			test();
		}
	}

	private boolean isMatch(String s, String p) {
		int sI = 0;
		int sJ = 0;
		boolean hasAsterisk = false;
		
		int i = 0, j = 0;
		while (j < s.length()) {
			if (i < p.length() && (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?')) {
				i++;
				j++;
			} else if (i < p.length() && p.charAt(i) == '*') {
//				Skip consecutive asterisks
				while (i < p.length() && p.charAt(i) == '*') {
					i++;
				}
				
//				Return true if the string ends with an asterisk
				if (i == p.length()) return true;
				
				hasAsterisk = true;
				sI = i;
				sJ = j;
			} else if (hasAsterisk) {
//				If it doesn't match, go back to last asterisk, forward source string by one
				i = sI;
				j = ++sJ;
			} else {
				return false;
			}
		}

		while (i < p.length()) {
			if (p.charAt(i++) != '*') return false;
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
