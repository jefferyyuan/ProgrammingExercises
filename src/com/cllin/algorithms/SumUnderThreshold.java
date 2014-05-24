package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * Given an array of integers with size n, and a threshold that is an integer.
 * Return the number of distinct pairs whose sum is smaller or equal than the threshold.
 * 
 * Source: http://www.careercup.com/question?id=5858156613730304
 */

public class SumUnderThreshold implements Exercise {

	private final int SIZE = 20;
	private final int MAXIMUM = 10;
	
	private int[] array;
	private int threshold;
	
	private int nPairs;
	
	private void initialize() {
		array = new int[SIZE];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * MAXIMUM);
		}
		
		threshold = (int) (Math.random() * MAXIMUM);;
	}
	
	@Override
	public void runExercise() {
		initialize();
		nPairs = getNumPairs(array, threshold);
		test();
	}

	private int getNumPairs(int[] array, int threshold) {
//		TODO
		return 0;
	}
	
	private void test() {
		System.out.print("A = { ");
		for (int n : array) {
			System.out.printf("%d ", n);
		}
		System.out.printf("},%nTHRESHOLD = %d.%nThere are %d pairs whose sum is smaller than THRESHOLD%n", threshold, nPairs);
	}
}
