package com.cllin.leetcode;

public class FirstMissingPositive implements LeetCodeExercise {
	
	private final int[][] testSuite = {
			{0},
			{1},
			{2},
			{1000, -1},
			{2, 2},
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

//		TODO
		
		return 0;
    }

	@Override
	public boolean test() {
		System.out.print("The missing positive integer of the sequence { ");
		for (int i = 0; i < testSuite[index].length; i++) System.out.printf("%d ", testSuite[index][i]);
		System.out.printf("} is %d%n", result);
		
		return true;
	}

}