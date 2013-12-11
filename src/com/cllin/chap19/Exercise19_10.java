package com.cllin.chap19;

import com.cllin.main.Exercise;

public class Exercise19_10 implements Exercise{

	@Override
	public void runExercise() {
		boolean[] existNum = new boolean[7];
		int[] numberCount = new int[7];
		
		final int nTests = 1000;
		
//		Run rand7() for 100 times, failed exists unexpected value
		for(int i = 0; i < nTests; i++){
			int result = rand7();
			if(result > 7 || result < 1 || result % 1 != 0){
				System.out.println("Failed");
				return;
			}
			existNum[result - 1] = true;
			numberCount[result - 1]++;
		}
		
//		Check if all number between 1-7 has been generated
		for(int i = 0; i < 7; i++){
			if(!existNum[i]){
				System.out.println("Failed");
				return;
			}
			System.out.println("P(" + (i + 1) + ")=" + ((float)numberCount[i]/nTests * 100) + "%");
		}
		System.out.println("Passed");
	}
	
	private int rand7(){
		int output = rand5();
		int delta = 2 - rand5() % 3;
		return output + delta;
	}
	
	private int rand5(){
		return 1 + (int)(Math.random() * 5);
	}
}
