package com.cllin.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII implements LeetCodeExercise {
	private final int MAXIMUM = 100;
	private final int SIZE = 100;
	
	private int[] array;
	private int result;
	
	@Override
	public void initialize() {
		array = new int[SIZE];
		result = SIZE;
		
		for (int i = 0; i < SIZE; i++) {
			array[i] = (int)(Math.random() * MAXIMUM);
		}
		
		Arrays.sort(array);
	}

	@Override
	public void runExercise() {
		initialize();
		
		result = removeDuplicates(array);
		if (test()) System.out.println("Success");
		else System.out.println("Failed");		
	}
	
    private int removeDuplicates(int[] array) {
    	if (array.length == 0) return 0; 
    	
    	int length = array.length;
    	int i = 0;
    	
    	while (i < length) {
    		if (array[i + 1] != array[i]) i++;
    		else {
    			if (array[i + 2] != array[i]) i += 2;
    			else {
    				for (int j = i + 2; j <= length - 2; j++) {
    					array[j] = array[j + 1];
    				}
    				length--;
    			}
    		}
    	}
    	
        return length;
    }

	@Override
	public boolean test() {
		int i = 0;
		
		while (i < result) {
			if (array[i + 1] != array[i]) i++;
			else {
				if (array[i + 2] != array[i]) i += 2;
				else return false;
			}
		}
		
		return true;
	}

}
