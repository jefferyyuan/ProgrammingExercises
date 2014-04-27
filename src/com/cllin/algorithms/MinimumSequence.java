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
	private int[] minimumSequence;
	
	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			for (sum = 1; sum <= 12; sum++) {
				minimumSequence = getMinimumSequence(testSuite[index], sum);
				test();
			}
		}
	}

	private int[] getMinimumSequence(int[] array, int target) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		if (sum < target) return new int[0];
		
		int start = 0;
		int end = array.length - 1;
		while (sum > target && start < end) {
			if (array[start] < array[end]) {
				if (sum - array[start] < target) break;
				sum -= array[start++];
			} else {
				if (sum - array[end] < target) break;
				sum -= array[end--];
			}
		}
		
		return new int[]{start, end};
	}
	
	private void test() {
		System.out.print("A = { ");
		for (int n : testSuite[index]) {
			System.out.printf("%d ", n);
		}
		System.out.printf("}%n");
		
		System.out.printf("S = %d%n", sum);
		
		System.out.print("Minimum Sequence = { ");
		int start = minimumSequence[0];
		int end = (minimumSequence.length == 1)? minimumSequence[0] : minimumSequence[1];
		for (int i = start; i <= end; i++) {
			System.out.printf("%d ", testSuite[index][i]);
		}
		System.out.printf("}%n");
		
		System.out.println("------------------------------");
	}
}
