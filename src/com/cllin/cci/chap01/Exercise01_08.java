package com.cllin.cci.chap01;

import com.cllin.main.Exercise;

/*
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * 
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring.
 * For example, "waterbottle" is a rotation of "erbottlewat"
 */

public class Exercise01_08 implements Exercise {

	private final TestCase[] testSuite = new TestCase[]{
			new TestCase("renderscript", "scriptrender"),
			new TestCase("readme", "mreead")
	};
	
	private TestCase testCase;

	@Override
	public void runExercise() {
		for (TestCase test : testSuite) {
			testCase = test;
			test();
		}
	}
	
	private void test() {
		String s1 = testCase.s1;
		String s2 = testCase.s2;
		
		System.out.printf("%s %s a rotation of %s%n", s2, (isRotation(s1, s2))? "is" : "is not", s1);
	}
	
	private boolean isRotation(String s1, String s2) {
		String string = s2 + s2;
		return isSubstring(string, s1);
	}
	
	private boolean isSubstring(String s1, String s2) {
		return s1.contains(s2);
	}
	
	private class TestCase {
		String s1;
		String s2;
		TestCase(String s1, String s2) {
			this.s1 = s1;
			this.s2 = s2;
		}
	}
}
