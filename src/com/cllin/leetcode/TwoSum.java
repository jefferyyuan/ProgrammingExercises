package com.cllin.leetcode;

import java.util.HashMap;

import com.cllin.main.LeetCodeExercise;

public class TwoSum implements LeetCodeExercise {

	private int[][] testSuite = {
			{2, 7, 11, 15},
			{3, 2, 4},
			{0, 4, 3, 0}
	};
	
	private int index;
	
	private int target;
	private int[] indices;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			
			for (target = 0; target < 10; target++) {
				indices = twoSum(testSuite[index], target);
				test();
			}
			
			System.out.println("------------------");
		}
	}
	
	private int[] twoSum(int[] numbers, int target) {
		int[] notFound = new int[]{-1, -1};
		if (numbers == null || numbers.length < 2) return notFound;
		
		HashMap<Integer, Integer> sorted = new HashMap<Integer, Integer>();
		int length = numbers.length;
		
		for (int p = 0; p < length; p++) {
			if (sorted.get(numbers[p]) == null) {
				sorted.put(numbers[p], p);
			}
			
			int key = target - numbers[p];
			Integer index = sorted.get(key);
			if (index != null && index.intValue() < p) {
				return new int[]{index.intValue() + 1, p + 1};
			}
			
		}
		
    	return notFound;
    }

	@Override
	public boolean test() {
		System.out.print("For the set { ");
		for (int n : testSuite[index]) System.out.printf("%d ", n);

		if (indices[0] == indices[1]) {
			System.out.printf("}, there is no pair whose sum is %d%n", target);
		} else {
			System.out.printf("}, the sum of element #%d and #%d is %d%n", indices[0], indices[1], target);
		}
		
		return true;
	}

}
