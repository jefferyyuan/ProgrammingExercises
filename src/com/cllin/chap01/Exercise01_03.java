package com.cllin.chap01;

import com.cllin.main.Exercise;

public class Exercise01_03 implements Exercise {

	@Override
	public void runExercise() {
		
//		Null String, All Spaces, All Dduplicates, No Duplicates, Continuous Duplicates, Noncontinuous Duplicates
		String[] testSuite = {null, "     ", "zzzzz", "car", "apple", "banana"};
		for(String string : testSuite){
			test(string);
		}
	}
	
	private String removeDuplicates(String string){
		if (string == null) return null;
		
		char[] input = string.toCharArray();
		int length = input.length;
		
		for(int i = 0; i < length; i++){
			for(int j = 0; j < i; j++){
				if(input[j] == input[i]){
					input[i] = '0';
				}
			}
		}
		
		return new String(input).replace("0", "");
	}
	
	private void test(String string){
		String output = removeDuplicates(string);
		
		if(output != null){
			int length = output.length();
			
			for(int i = 0; i < length; i++){
				for(int j = 0; j < i; j++){
					if(output.charAt(j) == output.charAt(i)){
						System.out.println("Failed");
						return;
					}
				}
			}
		}
		
		System.out.printf("Origin = %s, Output = %s%n", string, output);
	}

}
