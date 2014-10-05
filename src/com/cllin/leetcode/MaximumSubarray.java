package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2, 1, -3, 4, -1, 2, 1, -5, 4], the contiguous subarray [4, -1, 2, 1] has the largest sum = 6.
 * 
 * Source: http://oj.leetcode.com/problems/maximum-subarray/
 */

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
	public void run() {
		initialize();
		result = maxSubArray(array);
		test();
	}
	
	/*
	 * S(n) = S(n) = sum of maximum subarray that ends at n
	 * S(n) = 
	 * 		1) S(n - 1) + A(n), if S(n - 1) + A(n) > 0
	 * 		2) Else, 0
	 * 
	 * In another word, S(n) = max(S(n - 1) + A(n), 0)
	 */
    public int maxSubArray(int[] array) {
    	int length = array.length;
    	if (length == 0) return 0; 
    	
//    	If the elements are all negative, return the largest one
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
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < array.length; i++) {
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
