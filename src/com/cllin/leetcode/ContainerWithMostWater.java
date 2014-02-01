package com.cllin.leetcode;

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
	public void runExercise() {
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
    		int area = Math.min(height[left], height[right]) * (right - left);
    		max = Math.max(max, area);
    		
    		if (height[left] > height[right]) right--;
    		else left++;
    	}
    	
    	return max;
    }
    
	
    private int maxAreaRecursive(int[] height) {
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
		return (area == maxAreaRecursive(height))? true : false;
	}

}
