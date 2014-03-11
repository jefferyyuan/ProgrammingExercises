package com.cllin.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays implements LeetCodeExercise {
	
	private int MAXIMUM = 100;
	private int SIZE = 5;
	
	private int[] A;
	private int[] B;
	private double medium;

	@Override
	public void initialize() {
		A = new int[SIZE];
		B = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			A[i] = (int) (Math.random() * MAXIMUM);
			B[i] = (int) (Math.random() * MAXIMUM);
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
	}

	@Override
	public void runExercise() {
		for (int i = 0; i < 10; i++) {
			initialize();
			medium = findMedianSortedArrays(A, B);
			
			if (test()) System.out.println("Success");
			else System.out.println("Failed");
		}
	}
	
	private double findMedianSortedArrays(int A[], int B[]) {
		if (A == null || B == null) return 0;

		int lengthA = A.length;
		int lengthB = B.length;
		
		if ((lengthA + lengthB) % 2 == 0) {
			double p = getKth(A, B, (lengthA + lengthB) / 2, 0, A.length - 1, 0, B.length - 1);
			double q = getKth(A, B, (lengthA + lengthB) / 2 - 1, 0, A.length - 1, 0, B.length - 1);
			
			return (p + q) / 2;
		} else {
			return getKth(A, B, (lengthA + lengthB) / 2,0, A.length - 1, 0, B.length - 1);
		}
    }
	
	private double getKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {
		int lengthA = aEnd - aStart + 1;
		int lengthB = bEnd - bStart + 1;

		if (lengthA == 0) {
			return B[bStart + k];
		}
		
		if (lengthB == 0) {
			return A[aStart + k];
		}
		
		if (k == 0) {
			return (A[aStart] < B[bStart])? A[aStart] : B[bStart];
		}
		
		int aIdx = lengthA * k / (lengthA + lengthB);
		int bIdx = k - aIdx - 1;
		
		aIdx += aStart;
		bIdx += bStart;
		
		if (A[aIdx] >= B[bIdx]) {
			k -= (bIdx - bStart + 1);
			
			aEnd = aIdx;
			bStart = bIdx + 1;
		} else {
			k -= (aIdx - aStart + 1);
			
			aStart = aIdx + 1;
			bEnd = bIdx;			
		}
		
		return getKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}

	@Override
	public boolean test() {
		int[] merge = new int[A.length + B.length];
		for (int i = 0; i < merge.length; i++) {
			if (i < A.length) {
				merge[i] = A[i];
			} else {
				merge[i] = B[i - A.length];
			}
		}
		
		Arrays.sort(merge);
		double med = (merge.length % 2 == 1)? 
				merge[merge.length / 2] : (double) (merge[merge.length / 2] + merge[merge.length / 2 - 1]) / 2;
		
		return med == this.medium;
	}

}
