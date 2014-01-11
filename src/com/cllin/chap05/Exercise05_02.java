package com.cllin.chap05;

import com.cllin.main.Exercise;

public class Exercise05_02 implements Exercise {
	private final String[] testSuite = {"1.5", "3.1415926", "2.8", "0.5566"};

	@Override
	public void runExercise() {
		for(String n : testSuite){
			String inBinary = getInBinary(n);
			System.out.printf("%s is %s in binary%n", n, inBinary);
		}

	}
	
	private String getInBinary(String input){
		String output = new String();
//		TODO
		return output;
	}

}
