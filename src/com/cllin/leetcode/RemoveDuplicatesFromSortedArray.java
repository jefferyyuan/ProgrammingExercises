package com.cllin.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray implements LeetCodeExercise {
	private final int MAXIMUM = 100;
	private final int SIZE = 1000;
	
	private int[] array;
	private int result;
	
	@Override
	public void initialize() {
		array = new int[SIZE];
		result = -1;
		
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
	
    private int removeDuplicates(int[] A) {
    	int length = A.length;
    	int newLength = A.length;

    	int i = 1;
    	int j = 2;
    	
    	while (i < j && j < length) {
    		if (A[i] <= A[i - 1]) {
    			if (A[j++] > A[i - 1]) {
    				A[i++] = A[j++];
    				newLength--;
    			}
    		}
    	}
    	
    	for (int k = newLength; k < length; k++) {
    		A[k] =  -2147483648;
    	}
    	
    	return newLength;
    	
//    	int length = A.length;
//    	int newLength = A.length;
//
//    	for (int i = 1; i < length; i++) {
//    		if (A[i] <= A[i - 1]) {
//    			for (int j = i + 1; j < length; j++) {
//    				if (A[j] > A[i - 1]) {
//    					A[i] = A[j];
//    					newLength--;
//    					break;
//    				}
//    			}
//    		}
//    	}
//    	
//    	return newLength;
    }

	@Override
	public boolean test() {
		int length = array.length;
		int count = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j] && array[i] != -2147483648) return false;
			}
			
			if (array[i] != -2147483648) count++;
		}
		
		return (count == result)? true : false;
	}

}
