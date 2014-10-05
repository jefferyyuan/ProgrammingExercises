package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * For example, 
 * given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Source: http://oj.leetcode.com/problems/3sum-closest/
 */

public class ThreeSumClosest implements LeetCodeExercise {
	private final int MAXIMUM = 100;
	private int SIZE = 10;
	private int target;
	
	private int[] numbers;
	private int result;

	@Override
	public void initialize() {
		result = 0;
		numbers = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			numbers[i] = (int) (Math.random() * MAXIMUM) - (MAXIMUM / 2);
		}
	}

	@Override
	public void run() {
		initialize();
		int lowerBound = - (MAXIMUM / 2);
		int upperBound = MAXIMUM / 2;
		for (target = lowerBound; target < upperBound; target++) {
			result = threeSumClosest(numbers, target);
			test();
		}
	}
	
    private int threeSumClosest(int[] num, int target) {
    	int length = num.length;
    	if (length < 3) return 0;
    	
    	int sum = 0;
    	int closest = 1073741824;
    	Arrays.sort(num);
    	
    	int i = 0;
    	while (i <= length - 3) {
    		int a = num[i];
    		int j = i + 1;
    		int k = length - 1;
    		
    		while (j < k) {
    			sum = a + num[j] + num[k];
    			if (sum == target) return sum;
    			else if (sum > target) k--;
    			else j++;
    			
    			if (Math.abs(sum - target) < Math.abs(closest - target)) closest = sum;
    		}
    		
    		i++;
    	}
    	
        return closest;
    }

	@Override
	public boolean test() {
		System.out.printf("The closest 3 sum of %d is %d%n", target, result);
		return false;
	}

}
