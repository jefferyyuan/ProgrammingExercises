package com.cllin.cci.chap19;

import com.cllin.main.Exercise;

public class Exercise19_03 implements Exercise {

	@Override
	public void runExercise() {
		for(int i = 0; i < 10; i++){
			int n = (int)(Math.random() * 25);
			long input = getFactorial(n);
			System.out.println("***");
			System.out.println(input + " has " + getZeros(input) + " zeros");
//			ANOTHER APPROACH
			System.out.println(input + " has " + getFives(n) + " zeros");
		}
	}
	
	private int getZeros(long input){
		int number = 0;
		while(input % 10 == 0){
			number++;
			input /= 10;
		}
		return number;
	}
	
	private int getFives(int n){
		int counts = 0;
		
		for(int i = 5; n / i > 0; i *= 5){
			counts += n / i;
		}
		
		return counts;
	}
	
	private long getFactorial(int input){
		long factorial = 1;
		for(int i = 1; i < input + 1; i++){
			factorial *= i;
		}
		
		return factorial;
	}

}
