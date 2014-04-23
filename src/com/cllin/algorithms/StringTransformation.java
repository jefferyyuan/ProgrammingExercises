package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * Given a string which has numbers and letters. Numbers occupy all odd positions and letters even positions. 
 * You need to transform this string such that all letters move to front of array, and all numbers at the end. 
 * 
 * The relative order of the letters and numbers needs to be preserved
 * 
 * Example: a1b2c3d4 -> abcd1234 , x3y4z6 -> xyz346 
 * 
 * Source: http://www.careercup.com/question?id=5766198755065856
 */

public class StringTransformation implements Exercise {

	private final TestCase[] testSuite = {
			new TestCase("a1b2c3d4", "abcd1234"),
			new TestCase("x3y4z6", "xyz346"),
			new TestCase("a1b2c3d4e5f6g7h8i9j1k2l3m4", "abcdefghijklm1234567891234")
	};
	
	private int index;
	private String output;
	
	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			output = transform(testSuite[index].input);
			test();
		}
	}
	
	private String transform(String string) {
		int i, j;
		int length = string.length();
		char[] charArray = string.toCharArray();
		
		return new String(charArray);
	}
	
	private void test() {
		TestCase test = testSuite[index];

		System.out.printf("I = %s%nO = %s%n%s%n", testSuite[index].input, output, (output.equals(test.output))? "Correct!" : "Incorrect");
		System.out.println("------------------------------");
	}

	private class TestCase {
		String input;
		String output;
		
		TestCase(String input, String output) {
			this.input = input;
			this.output = output;
		}
	}
}
