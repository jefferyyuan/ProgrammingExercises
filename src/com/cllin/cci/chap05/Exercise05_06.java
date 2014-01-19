package com.cllin.cci.chap05;

import com.cllin.main.Exercise;

public class Exercise05_06 implements Exercise {
	private final int[] testSuite = {1, 4, 6, 10, 73, 183, 5566};
	
	@Override
	public void runExercise() {
		for(int n : testSuite){
			int output = swapEvenAndOddBits(n);
			System.out.printf("%s -> %s%n",
					Integer.toBinaryString(n), 
					Integer.toBinaryString(output));
		}

	}
	
	private int swapEvenAndOddBits(int input){
		int output = 0;
		
		int copyOddToEven = (input << 1) & 0XAAAAAAAA;
		int copyEvenToOdd = (input >> 1) & 0X55555555;
		output = copyEvenToOdd | copyOddToEven;
		
		return output;
	}

}
