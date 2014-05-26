package com.cllin.cci.chap01;

import com.cllin.main.Exercise;

/*
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 * 
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 * FOLLOW UP: Write the test cases for this method.
 */

public class Exercise01_03 implements Exercise {

//	Null string, all duplicates, no duplicates, continuous duplicates, non-continuous duplicates
	private final String[] testSuite = {null, "zzzzz", "car", "apple", "banana"};
	
	@Override
	public void runExercise() {
		for (String string : testSuite) {
			test(string);
		}
	}
	
	private String removeDuplicates(String string) {
		if (string == null) return null;
		
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			boolean isDuplicate = false;
			
			for (int j = 0; j < i; j++) {
				if (string.charAt(j) == string.charAt(i)) {
					isDuplicate = true;
					break;
				}
			}
			
			if (!isDuplicate) buffer.append(string.charAt(i));
		}
		
		return buffer.toString();
	}
	
	private void test(String string){
		String output = removeDuplicates(string);
		
		if (output != null) {
			for (int i = 0; i < output.length(); i++) {
				for (int j = 0; j < i; j++) {
					if (output.charAt(j) == output.charAt(i)) {
						System.out.println("Failed");
						return;
					}
				}
			}
		}
		
		System.out.printf("Origin = %s, Output = %s%n", string, output);
	}

}
