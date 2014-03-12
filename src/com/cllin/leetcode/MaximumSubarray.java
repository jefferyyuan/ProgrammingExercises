package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;


public class MaximumSubarray implements LeetCodeExercise {
	private final int MAXIMUM = 100;
	private final int SIZE = 1000;
	
	private int[] array;
	private int result;
	
	@Override
	public void initialize() {
		array = new int[SIZE];
		result = 0;
		
		for (int i = 0; i < SIZE; i++) {
			int value = (int)(Math.random() * MAXIMUM);
			if (Math.random() > 0.5) value *= -1;
			
			array[i] = value;
		}
	}

	@Override
	public void runExercise() {
		initialize();
		result = maxSubArray(array);
		test();
	}
	
    public int maxSubArray(int[] array) {
    	int length = array.length;
    	if (length == 0) return 0; 
    	
        int sum = detect(array);
        if (sum < 0) return sum;
        
        int max = array[0];
        for (int i = 0; i < length; i++) {
            sum += array[i];
            sum = Math.max(0, sum);
            max = Math.max(sum, max);
        }
        
        return max;
    }

    private int detect(int[] array) {
    	int length = array.length;
        int max = array[0];
        for (int i = 0; i < length; i++) {
            if (array[i] >= 0) return 0;
            max = Math.max(array[i], max);
        }
        return max;
    }

	@Override
	public boolean test() {
		System.out.printf("The sum of the maximum subarray is %d%n", result);
		return true;
	}

}
