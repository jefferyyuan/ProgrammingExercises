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
    	if (A.length == 0) return 0;
    	int length = A.length;
    	
        int i = 0;
        int j = 1;

        for (j = 1; j < length; j++) {            
        	if (A[j] != A[i]) A[++i] = A[j];
        }
        
//      Values are set to -2147483648 to pass own test cases
        for (int k = i + 1; k < length; k++) {
        	A[k] = -2147483648;
        }
        
        return i + 1;
    }

	@Override
	public boolean test() {
		int length = array.length;
		int count = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j] && array[i] != -2147483648) {
					return false;
				}
			}
			
			if (array[i] != -2147483648) count++;
		}
		
		return (count == result)? true : false;
	}

}
