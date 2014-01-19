package com.cllin.cci.chap01;

import com.cllin.main.Exercise;

public class Exercise01_01 implements Exercise {

	@Override
	public void runExercise() {
		String[] testSuite = {null, "     ", "zzzzz", "car", "apple", "banana"};
		for(String string : testSuite){
			printResult(string);;
		}
	}
	
	private boolean isAllUnique(String string){
		if (string == null || string.length() == 1) return true;
		
		int length = string.length();
		for(int i = 0; i < length; i++){
			for(int j = 0; j < i; j++){
				if(string.charAt(i) == string.charAt(j)){
					return false;
				}
			}
		}
		
		return true;
	}
	
	private void printResult(String string){
		if (isAllUnique(string)) System.out.printf("%s has all unique characters%n", string);
		else System.out.printf("%s has duplicate characters%n", string);
	}

}
