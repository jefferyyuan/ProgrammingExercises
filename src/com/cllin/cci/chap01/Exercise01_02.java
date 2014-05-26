package com.cllin.cci.chap01;

import com.cllin.main.Exercise;

/*
 * Write code to reverse a C-Style String.
 * (C-String means that "abcd" is represented as five characters, including the null character.)
 */

public class Exercise01_02 implements Exercise {

	private final String[] testSuite = {null, "a", "ooOoo", "car", "apple", "banana"};

	@Override
	public void runExercise() {
		for(String string : testSuite){
			printResult(string);
		}
	}
	
	private String getReverse(String string) {
		if (string == null || string.length() == 1) return string;
		
		int length = string.length();
		char[] characters = new char[length];

		for (int i = 0; i < length; i++) {
			characters[i] = string.charAt(length - i - 1);
		}
		
		return new String(characters);
	}
	
	private void printResult(String string) {
		System.out.printf("The reverse of %s is %s%n", string, getReverse(string));
	}

}
