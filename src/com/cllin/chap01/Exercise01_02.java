package com.cllin.chap01;

import com.cllin.main.Exercise;

public class Exercise01_02 implements Exercise {

	@Override
	public void runExercise() {
		String[] testSuite = {null, "a", "ooOoo", "car", "apple", "banana"};
		for(String string : testSuite){
			printResult(string);;
		}

	}
	
	private String getReverse(String string){
		if (string == null || string.length() == 1) return string;
		
		int length = string.length();
		char[] characters = new char[length];

		for(int i = 0; i < length; i++){
			characters[i] = string.charAt(length - i - 1);
		}
		
		return new String(characters);
	}
	
	private void printResult(String string){
		System.out.printf("The reverse of %s is %s%n", string, getReverse(string));
	}

}
