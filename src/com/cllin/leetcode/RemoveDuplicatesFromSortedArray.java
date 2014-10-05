package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a sorted array, 
 * remove the duplicates in place such that each element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * Source: http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

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
	public void run() {
		initialize();
		
		result = removeDuplicates(array);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");		
	}
	
	/*
	 * i indicates the last unique element
	 * j traverses the entire array, if there is a new unique element, move it after the previous unique element
	 */
    private static int removeDuplicates(int[] A) {
    	if (A.length == 0) return 0;
    	
        int i = 0;
        int j = 1;
        while (j < A.length) {
        	if (A[j] != A[i]) {
        		A[++i] = A[j];
        	}
        	
        	j++;
        }
        
//      Values are set to Integer.MIN_VALUE to pass my own test cases
        for (int k = i + 1; k < A.length; k++) {
        	A[k] = Integer.MIN_VALUE;
        }
        
        return i + 1;
    }

	@Override
	public boolean test() {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j] && array[i] != Integer.MIN_VALUE) {
					return false;
				}
			}
			
			if (array[i] != Integer.MIN_VALUE) count++;
		}
		
		return count == result;
	}

}
