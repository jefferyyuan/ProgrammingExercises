package com.cllin.leetcode;

import java.util.Arrays;

public class SearchInRotatedSortedArrayII implements LeetCodeExercise {
	private final int MAXIMUM = 200;
	private final int SIZE = 100;
	
	private int[] numbers;
	private int target;
	private boolean result;

	@Override
	public void initialize() {
		result = false;
		target = (int) (Math.random() * MAXIMUM);
		
		int[] tmp = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			tmp[i] = (int) (Math.random() * MAXIMUM);
		}
		
		Arrays.sort(tmp);
		
		int pivot = (int) (Math.random() * SIZE);
		numbers = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			if (i < SIZE - pivot) numbers[i] = tmp[i + pivot];
			else numbers[i] = tmp[i - SIZE + pivot];
		}
	}

	@Override
	public void runExercise() {
		for (int i = 0; i < 10; i++) {
			initialize();
			
			result = search(numbers, target);
			if (test()) System.out.println("Success");
			else System.out.println("Failed");	
		}
	}
	
    private boolean search(int[] numbers, int target) {
    	int length = numbers.length;
    	
    	if (length == 0) return false;
    	else if (length == 1) return (numbers[0] == target);
    	
    	if (target < numbers[0]) {
    		for (int i = length - 1; i >= 0; i--) {
    			if (target == numbers[i]) return true; 
    			else if (target > numbers[i]) return false;
    			
    			if (i > 0 && numbers[i] < numbers[i - 1]) break;
    		}
    	} else if (target > numbers[0]) {
    		for (int i = 0; i <= length - 1; i++) {
    			if (target == numbers[i]) return true; 
    			else if (target < numbers[i]) return false;
    			
    			if (i < length - 1 && numbers[i] > numbers[i + 1]) break;
    		}
    	} else {
    		return true;
    	}
    	
    	return false;
    }

	@Override
	public boolean test() {
		boolean found = false;
		int length = numbers.length;
		
		for (int i = 0; i < length; i++) {
			if (numbers[i] == target) {
				found = true;
				break;
			}
		}
		
		return (found == result);
	}

}
