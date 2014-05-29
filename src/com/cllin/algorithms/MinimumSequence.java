package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * Determine minimum sequence of adjacent values in the input parameter array that is greater than input parameter sum. 
 * 
 * For example, A = {2, 1, 1, 4, 3, 6}, S = 8
 * Answer is 2, because 3, 6 is minimum sequence greater than 8.
 * 
 * Source: http://www.careercup.com/question?id=5653018213089280
 */

public class MinimumSequence implements Exercise {

	private int[][] testSuite = {
			{2, 1, 1, 4, 3, 6}
	};
	
	private int index;
	private int sum;
	private int minimumSequenceLength;
	
	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			for (sum = 1; sum <= 12; sum++) {
				minimumSequenceLength = getMinimumSequenceLength(testSuite[index], sum);
				test();
			}
		}
	}

	private int getMinimumSequenceLength(int[] array, int target) {
//		TODO
		return -1;
	}
	
	private void test() {
		System.out.print("A = { ");
		for (int n : testSuite[index]) {
			System.out.printf("%d ", n);
		}
		System.out.printf("}%n");
		
		System.out.printf("S = %d%n", sum);
		
		if (minimumSequenceLength == -1) {
			System.out.printf("Does not exist subsequence whose sum is larger than %d%n", sum);
			return;
		}
		
		System.out.printf("Minimum sequence length = %d%n", minimumSequenceLength);
		
		System.out.println("------------------------------");
	}
}
