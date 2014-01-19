package com.cllin.cci.chap01;

import com.cllin.main.Exercise;

public class Exercise01_05 implements Exercise {
	private final String string = "true and false are defined constants of the language and are not the same as True and False, TRUE and FALSE, zero and nonzero, 1 and 0 or any other numeric value";

	@Override
	public void runExercise() {
		String output = replaceSpaces(string);
		
		System.out.printf("Origin = %s%n", string);
		System.out.printf("Output = %s%n", output);
	}
	
	private String replaceSpaces(String input){
		StringBuffer output = new StringBuffer();
		
		int length = input.length();
		for(int i = 0; i < length; i++){
			if (input.charAt(i) == ' ') output.append("%20");
			else output.append(input.charAt(i));
		}
		
		return output.toString();
	}

}
