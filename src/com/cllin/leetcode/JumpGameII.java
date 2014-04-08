package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class JumpGameII implements LeetCodeExercise {

	private final int[][] testSuite = {
			{2, 3, 1, 1, 4}, 
			{0}, 
			{1},
			{2, 1},
			{1, 2, 0, 1},
			{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0},
			{1, 1, 1, 1, 1, 1, 1, 1}
	};
	
	private int index;
	private int numMinimumJumps;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			numMinimumJumps = jump(testSuite[index]);
			test();
		}
	}
	
	private int jump(int[] array) {
		if (array == null || array.length <= 1) return 0;
		if (array[0] == 0) return -1;
		
		int count = 0;
		int last = 0;
		int current = 0;
		int length = array.length;
		
		for (int i = 0; i < length; i++) {
			if (i > last) {
				if (current == last && last < length - 1) return -1;
				
				last = current;
				count++;
			}
			
			current = Math.max(current, i + array[i]);
		}
		
		return count;
	}

	@Override
	public boolean test() {
		System.out.print("For the array { ");
		for (int num : testSuite[index]) System.out.printf("%d ", num);
		
		System.out.printf("}, it takes at least %d jumps to finish%n", numMinimumJumps);
		return true;
	}

}
