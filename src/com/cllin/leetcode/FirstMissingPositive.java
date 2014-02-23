package com.cllin.leetcode;

public class FirstMissingPositive implements LeetCodeExercise {
	
	private final int[][] testSuite = {
			{0},
			{1, 2, 0},
			{3, 4, -1, 1}
	};
	
	private int index;
	private int result;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			result = firstMissingPositive(testSuite[index]);
			test();
		}
	}
	
	private int firstMissingPositive(int[] array) {
		if (array == null || array.length == 0) return 1;
		
		int length = array.length;
		int sum = 0;
		int max = 0;
		int min = 2147483647;
		for (int i = 0; i < length; i++) {
			if (array[i] > 0) {
				max = Math.max(max, array[i]);
				min = Math.min(min, array[i]);
				sum += array[i];
			}
		}
		
		int delta = (max == 0)? 1 : (max + min) * (max - min + 1) / 2 - sum;
    	return (delta == 0)? max + 1 : delta;
    }

	@Override
	public boolean test() {
		System.out.printf("missing = %d%n", result);
		return false;
	}

}
