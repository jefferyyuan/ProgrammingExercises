package com.cllin.cci.chap01;

import com.cllin.main.Exercise;

/*
 * Write a method to replace all spaces in a string with '%20'.
 */

public class Exercise01_05 implements Exercise {
	
	private final String[] testSuite = new String[]{
			"true and false are defined constants of the language and are not the same as True and False"
	};
	
	private String input;
	private String output;

	@Override
	public void runExercise() {
		for (String string : testSuite) {
			input = string;
			output = replaceSpaces(input);
			test();
		}
	}
	
	private String replaceSpaces(String input) {
		StringBuffer output = new StringBuffer();
		
		for(int i = 0; i < input.length(); i++){
			output.append((input.charAt(i) == ' ')? "%20" : input.charAt(i));
		}
		
		return output.toString();
	}

	private void test() {
		System.out.printf("Origin = %s,%nOutput = %s%n", input, output);
	}
}
