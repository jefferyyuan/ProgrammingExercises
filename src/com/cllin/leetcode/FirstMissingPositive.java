package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

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
		
		int length = array.length;
		int shift = segregate(array);
		
		int index;
		for (int i = shift; i < length; i++) {
			index = Math.abs(array[i]) - 1 + shift;
			if (index < length && array[index] > 0) {
				array[index] = (-1) * array[index];
			}
		}
		
		for (int i = shift; i < length; i++) {
			if (array[i] > 0) {
				return i - shift + 1;
			}
		}
		
		return length - shift + 1;
    }
	
	private int segregate(int[] array) {
		int temp;
		int shift = 0;
		int length = array.length;
		
		for (int i = 0; i < length; i++) {
			if (array[i] <= 0) {
				temp = array[i];
				array[i] = array[shift];
				array[shift] = temp;
				
				shift++;
			}
		}
		
		return shift;
	}

	@Override
	public boolean test() {
		System.out.print("The missing positive integer of the sequence { ");
		for (int i = 0; i < testSuite[index].length; i++) System.out.printf("%d ", testSuite[index][i]);
		System.out.printf("} is %d%n", result);
		
		return true;
	}

}