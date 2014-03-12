package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;


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
		
//		numbers = new int[]{0, 1, 2};
	}

	@Override
	public void runExercise() {
		
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
