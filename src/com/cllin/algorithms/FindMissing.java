package com.cllin.algorithms;

import java.util.Arrays;
import java.util.HashSet;

import com.cllin.main.Exercise;

/*
 * Given two arrays of integers. 
 * The first array is sorted.
 * The second array is a copy of the first array, but it has a missing element. Find the missing element. 
 */

public class FindMissing implements Exercise {

	private static final int SIZE = 5;
	private static final int MAXIMUM = 1000;
	
	private int[] array1;
	private int[] array2;
	private int missingValue;
	private int reference;
	
	@Override
	public void runExercise() {
		for (int i = 0; i < 100; i++) {
			initialize();
			missingValue = getMissing(array1, array2);
			
			if (missingValue != reference) {
				System.out.println("Failed");
				return;
			}
		}
		
		System.out.println("Success!");
	}
	
	private int getMissing(int[] A1, int[] A2) {
		int start = 0;
		int end = A1.length - 1;
		int mid = 0;
		
		while (start < end) {
			mid = (start + end) / 2;
			if (start + 1 == end) {
				break;
			}
			
			if (A2[mid] > A1[mid]) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		return (A1[start] == A2[start])? A1[end] : A1[start];
	}
	
	private void initialize() {
		array1 = new int[SIZE];
		array2 = new int[SIZE - 1];

		HashSet<Integer> set = new HashSet<Integer>();
		while (set.size() < SIZE) {
			set.add((int) (Math.random() * MAXIMUM));
		}

		int i = 0;
		for (Integer n : set) {
			array1[i++] = n;
		}
		Arrays.sort(array1);
		
		i = 0;
		int j = 0;
		int missingIndex = (int) (Math.random() * SIZE);
		while (i < array1.length) {
			if (i == missingIndex) {
				reference = array1[i++];
			} else {
				array2[j++] = array1[i++];
			}
		}
	}

}
