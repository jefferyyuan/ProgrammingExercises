package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two end points of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * Source: http://oj.leetcode.com/problems/container-with-most-water/
 */

public class ContainerWithMostWater implements LeetCodeExercise {
	private final int MAXIMUM = 2;
	private final int SIZE = 100;
	
	private int[] height;
	private int area;
	
	@Override
	public void initialize() {
		height = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			height[i] = (int)(Math.random() * MAXIMUM);
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			initialize();
			area = maxArea(height);
			
			if (test()) System.out.println("Success");
			else System.out.println("Failed");	
		}
	}
    
    private int maxArea(int[] height) {
    	int length = height.length;
    	if (length == 0) return 0;
    	
    	int max = 0;
    	int left = 0;
    	int right = length - 1;

    	while (left < right) {
    		max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
    		
    		if (height[left] > height[right]) right--;
    		else left++;
    	}
    	
    	return max;
    }
	
    private int maxAreaNaive(int[] height) {
    	int length = height.length;
    	if (length == 0) return 0;
    	
    	int max = 0;
    	
    	for (int i = 0; i < length; i++) {
    		for (int j = 0; j <= i - 1; j++) {
    			max = Math.max(max, (i - j) * Math.min(height[i], height[j]));
    		}
    	}
    	return max;
    }

	@Override
	public boolean test() {
		return (area == maxAreaNaive(height))? true : false;
	}

}
