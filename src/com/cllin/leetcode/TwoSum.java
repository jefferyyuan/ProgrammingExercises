package com.cllin.leetcode;

import java.util.HashMap;

import com.cllin.main.LeetCodeExercise;

/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Source: http://oj.leetcode.com/problems/two-sum/
 */

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
		}
	}
	
	/*
	 * Use a hashmap to avoid the time cost for sorting the array.
	 * If space is the concern, sort the array and search with two indices.
	 */
	private int[] twoSum(int[] numbers, int target) {
		int[] notFound = new int[]{-1, -1};
		if (numbers == null || numbers.length < 2) return notFound;
		
		HashMap<Integer, Integer> sorted = new HashMap<Integer, Integer>();
		for (int p = 0; p < numbers.length; p++) {
			if (!sorted.containsKey(numbers[p])) sorted.put(numbers[p], p);
			
			int key = target - numbers[p];
			if (sorted.containsKey(key) && sorted.get(key) != p) {
				return new int[]{sorted.get(key) + 1, p + 1};
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
		
		System.out.println("------------------------------");
		return true;
	}

}
