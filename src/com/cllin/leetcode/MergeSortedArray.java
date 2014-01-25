package com.cllin.leetcode;

import java.util.Arrays;

public class MergeSortedArray implements LeetCodeExercise {
	private final int MAXIMUM = 100;
	private final int SIZE = 100;
	private final int SIZE_A = 50;
	private final int SIZE_B = 30;
	
	private int[] arrayA;
	private int[] arrayB;
	private int[] reference;
	
	@Override
	public void initialize() {
		arrayA = new int[SIZE];
		arrayB = new int[SIZE_B];
		reference = new int[SIZE_A + SIZE_B];
		
		Arrays.fill(arrayA, 2147483647);

		for (int i = 0; i < SIZE_A; i++) {
			int value = (int)(Math.random() * MAXIMUM);
			arrayA[i] = value;
			reference[i] = value;
		}
		
		for (int i = 0; i < SIZE_B; i++) {
			int value = (int)(Math.random() * MAXIMUM);
			arrayB[i] = value;
			reference[i + SIZE_A] = value;
		}
		
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		Arrays.sort(reference);
	}

	@Override
	public void runExercise() {
		initialize();
		
		merge(arrayA, SIZE_A, arrayB, SIZE_B);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
    private void merge(int A[], int m, int B[], int n) {
    	if (A.length == 0 || B.length == 0) return;
    	
    	int i = 0;
    	int j = 0;
    	int delta = 0;
    	
    	while (i < m || j < n) {
    		if (i < m + delta && A[i] < B[j]) {
    			i++;
    		} else {
    			for (int p = m + delta - 1; p >= i ; p--) {
    				A[p + 1] = A[p];
    			}
    			delta++;
    			
    			A[i] = B[j];
    			
    			i++;
    			j++;
    		}
    		if (j >= n) break;
    	}
    }

	@Override
	public boolean test() {
		int length = arrayA.length;
		int validLength = SIZE_A + SIZE_B;
		
		for (int i = 0; i < validLength; i++) {
			if (arrayA[i] != reference[i]) {
				return false;
			}
		}
		
		for (int i = validLength; i < length; i++) {
			if (arrayA[i] != 2147483647) {
				return false;
			}
		}
		
		
		return true;
	}

}
