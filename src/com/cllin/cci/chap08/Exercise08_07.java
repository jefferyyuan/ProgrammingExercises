package com.cllin.cci.chap08;

import com.cllin.main.Exercise;

public class Exercise08_07 implements Exercise {
	private final int[] testSuites = {1, 27, 39, 100, 25, 492, 20, 1734, 5566, 183, 5};

	@Override
	public void runExercise() {
		for(int n : testSuites){
			int ways = makeChanges(n, 25);
			System.out.println("There are " + ways + " ways of changes for " + n);
		}

	}
	
	private int makeChanges(int n, int denominator){
		int ways = 0;
		int nextDenominator = 0;
		
		switch(denominator){
		case 25:
			nextDenominator = 10;
			break;
		case 10:
			nextDenominator = 5;
			break;
		case 5:
			nextDenominator = 1;
			break;
		case 1:
			return 1;
		}
		
		int bound = n / denominator + 1;
		for(int i = 0; i < bound; i++){
			ways += makeChanges(n - i * denominator, nextDenominator);
		}
		
		return ways;
	}

}
