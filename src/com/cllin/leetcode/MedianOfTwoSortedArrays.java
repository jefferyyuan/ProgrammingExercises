package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * Source: http://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 */

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
			return getKth(A, B, (lengthA + lengthB) / 2, 0, A.length - 1, 0, B.length - 1);
		}
    }
	
	/*
	 * Say, we want the k-th element of A + B.
	 * 
	 * In a sorted array, A[i] is larger than exact i elements, making it the (i + 1)-th element.
	 * 
	 * A[i] is the (i + 1)-th element of A(aStart, aEnd).
	 * B[j - 1] is the (j)-th element of B(bStart, bEnd).
	 * 
	 * If B[j - 1] < A[i] < B[j], A[i] is the (i + 1 + j)-th element of A + B.
	 * In this case,
	 * 		k = i + j + 1, and
	 * 		i = k * A / (A + B), so
	 * 		j = k - i - 1
	 */
	private double getKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {
		int lengthA = aEnd - aStart + 1;
		int lengthB = bEnd - bStart + 1;

		if (lengthA == 0) return B[bStart + k];
		if (lengthB == 0) return A[aStart + k];
		
		if (k == 0) {
			return (A[aStart] < B[bStart])? A[aStart] : B[bStart];
		}
		
		int i = lengthA * k / (lengthA + lengthB);
		int j = k - i - 1;

//		Shift the indices
		i += aStart;
		j += bStart;

		if (A[i] >= B[j]) {
//			The new array contains the first half of A and second half of B
			k -= (j - bStart + 1);

			aEnd = i;
			bStart = j + 1;
		} else {
//			The new array contains the second half of A and first half of B
			k -= (i - aStart + 1);

			aStart = i + 1;
			bEnd = j;			
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
