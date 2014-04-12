package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, 
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * Source: http://oj.leetcode.com/problems/sort-colors/
 */

public class SortColors implements LeetCodeExercise {
	private final int MAXIMUM = 3;
	private final int SIZE = 10;
	
	private int[] numbers;
	
	@Override
	public void initialize() {
		numbers = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			numbers[i] = (int)(Math.random() * MAXIMUM);
		}
	}

	@Override
	public void runExercise() {
		initialize();
		
		numbers = sortColors(numbers);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
    private int[] sortColors(int[] A) {
    	if (A.length == 0) return null;
    	
    	int R = 0;
    	int B = A.length - 1;
    	
    	int i = 0;
    	while (i < B + 1) {
    		switch(A[i]) {
    		case 0:
    			swap(A, R++, i);
    			break;
    		case 2:
    			swap(A, B--, i);
    			continue;
    		}
    		
    		i++;
    	}
    	
        return A;
    }
    
    private void swap(int[] A, int x, int y) {
    	int temp = A[x];
    	A[x] = A[y];
    	A[y] = temp;
    }

	@Override
	public boolean test() {
		for (int i = 1; i < SIZE; i++) {
			if (numbers[i] < numbers[i - 1]) return false;
		}
		
		return true;
	}

}
