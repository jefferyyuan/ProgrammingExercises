package com.cllin.chap05;

import com.cllin.main.Exercise;

public class Exercise05_03 implements Exercise {
	private final int[] testSuite = {2, 6, 16, 30, 126, 254, 512};

	@Override
	public void runExercise() {
		for(int n : testSuite){
			int nextSmallest = getNextSmallestNumber(n);
			int nextLargest = getNextLargestNumber(n);
			
			System.out.printf("N = %d, NextSmallestNumber(N) = %d, NextLargestNumber = %d%n", n, nextSmallest, nextLargest);
		}

	}
	
	private int getNextSmallestNumber(int input){
		int output = 0;
		
		int msb = -1;
		int nOnes = 0;
		while(input > 0){
			if (input % 2 == 1) nOnes++;
			input >>= 1;
			msb++;
		}
		
		for(int i = 0; i < nOnes - 1; i++){
			output += (1 << i);
		}
		output += (1 << (msb + 1));
		
		return output;
	}
	
	private int getNextLargestNumber(int input){
		int output = 0;

		int msb = -1;
		int nOnes = 0;
		while(input > 0){
			if (input % 2 == 1) nOnes++;
			input >>= 1;
			msb++;
		}
		
		for(int i = msb - 1; i >= msb - nOnes; i--){
			output += (1 << i);
		}
		
		return output;
	}

}
