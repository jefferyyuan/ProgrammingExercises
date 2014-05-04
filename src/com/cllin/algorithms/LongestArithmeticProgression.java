package com.cllin.algorithms;

import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Given an array of integers A, give an algorithm to find the longest Arithmetic progression in it.
 * 
 * i.e find a sequence i1 < i2 < ... < ik, such that A[i1], A[i2], ..., A[ik] forms an arithmetic progression, 
 * and k is the largest possible.
 * 
 * The sequence S1, S2, ..., Sk is called an arithmetic progression if Sj+1 ¡V Sj is a constant.
 * 
 * Source: http://www.geeksforgeeks.org/forums/topic/google-interview-question-16/
 */

public class LongestArithmeticProgression implements Exercise {

	private final int MAXIMUM = 20;
	private final int SIZE = 10;
	
	private int[] array;
	private int maximumLength;
	
	@Override
	public void runExercise() {
		initialize();
		maximumLength = getLongestArithmeticProgression(array);
		test();
	}
	
	/*
	 * L(i) = length of the maximum arithmetic progressive sequence that ends at i
	 * C(i) = constant of the maximum arithmetic progressive sequence that ends at i
	 *
	 * Initially,
	 * L(i) = 1, C(i) = A(0)			--- i == 0
	 * L(i) = 2, C(i) = A(i) - A(0)		--- i > 0
	 * 
	 * L(i) = L(j) = 1; C(i) = C(j) if:
	 * 		A(j) + L(j) == A(i) AND L(j) + 1 > L(i)
	 * 
	 * 		0 <= j < i
	 */
	private int getLongestArithmeticProgression(int[] array) {
		int length = array.length;
		int maximum = Integer.MIN_VALUE;
		int[] sequenceLength = new int[length];
		int[] constant = new int[length];
		
		Arrays.sort(array);
		
		for (int i = 0; i < length; i++) {
			sequenceLength[i] = 1;
			constant[i] = 0;
			
			for (int j = 0; j < i; j++) {
				if (j == 0) {
					sequenceLength[i] = 2;
					constant[i] = array[i] - array[j];
					continue;
				}
				
				if (array[j] + constant[j] == array[i] && sequenceLength[j] + 1 > sequenceLength[i]) {
					sequenceLength[i] = sequenceLength[j] + 1;
					constant[i] = constant[j];
					
					maximum = Math.max(maximum, sequenceLength[i]);
				}
			}
		}
		
		return maximum;
	}
	
	private void test() {
		System.out.print("A = { ");
		for (int n : array) {
			System.out.printf("%d ", n);
		}
		System.out.printf("}%n");
		
		System.out.printf("Length of the Longest Arithmetic Progression = %d%n", maximumLength);
		
	}

	private void initialize() {
		array = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			array[i] = (int) (Math.random() * MAXIMUM);
		}
	}
}
