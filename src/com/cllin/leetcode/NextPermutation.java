package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 		1, 2, 3 -> 1, 3, 2
 * 		3, 2, 1 -> 1, 2, 3
 * 		1, 1, 5 -> 1, 5, 1
 * 
 * Source: http://oj.leetcode.com/problems/next-permutation/
 */

public class NextPermutation implements LeetCodeExercise {
	private final int[][] testSuite = {
			{1, 2, 3}, 
			{3, 2, 1}, 
			{1, 1, 5},
			{1, 3, 2},
			{1, 4, 3, 2},
			{2, 3, 1},
			{4, 2, 0, 2, 3, 2, 0}
	};

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (int[] test : testSuite) {
			nextPermutation(test);
		}
	}
	
	private void nextPermutation(int[] num) {
		if (num == null) return;
		if (num.length == 0) return;
		
		int length = num.length;
		boolean isDescending = true;
		for (int i = 1; i < length; i++) {
			if (num[i - 1] < num[i]) {
				isDescending = false;
				break;
			}
		}
		
		if (isDescending) {
			for (int i = 0; i < length / 2; i++) {
				int buf = num[i];
				num[i] = num[length - 1 - i];
				num[length - 1 - i] = buf;
			}
		} else {
//			Find the least-significant ascending pair, save their indices as p and q
			int p = -1;
			int q = -1;
			int start = 0;
			while (start < length) {
				int m = -1;
				for (int i = start; i < length; i++) {
					if (num[start] < num[i]) {
						m = i;
					}
				}
				
				if (m != -1) {
					p = start;
					q = m;
				}
				
				start++;
			}
			
//			Swap the least-significant ascending pair
			int buf = num[p];
			num[p] = num[q];
			num[q] = buf;
			
//			Sort the numbers after p
			for (int i = p + 1; i < length; i++) {
				for (int j = i + 1; j < length; j++) {
					if (num[i] > num[j]) {
						buf = num[i];
						num[i] = num[j];
						num[j] = buf;
					}
				}
			}
		}
		
		for (int i = 0; i < length; i++) System.out.printf("%d ", num[i]);
		System.out.println();
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
