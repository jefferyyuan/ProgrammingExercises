package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class JumpGame implements LeetCodeExercise {
	private final int[][] testSuite = {
			{2, 3, 1, 1, 4},
			{3, 2, 1, 0, 4},
			{2, 0}, 
			{0}
	};
	
	private int index;
	private boolean result;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			result = canJump(testSuite[index]);
			test();
		}
	}
	
	private boolean canJump(int[] array) {
		int length = array.length;
		if (length == 0) return false;
		
		int index = 0;
		while (index < length) {
			if (array[index] == 0) break;
			index += array[index];
		}
		
		return (index >= length - 1)? true : false;
    }

	@Override
	public boolean test() {
		int[] array = testSuite[index];
		
		System.out.print("For this array: {");
		for (int i = 0; i < array.length; i++) System.out.printf(" %d", array[i]);
		if (result) System.out.print(" }, it is possible to finish to jump game\n");
		else System.out.print(" }, it is impossible to finish to jump game\n");
		
		return false;
	}

}
