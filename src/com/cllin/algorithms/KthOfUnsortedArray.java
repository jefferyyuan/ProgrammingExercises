package com.cllin.algorithms;

import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Find the k-th largest element in an unsorted array of length n in O(n)
 * 
 * Source: http://stackoverflow.com/questions/251781/how-to-find-the-kth-largest-element-in-an-unsorted-array-of-length-n-in-on
 */

public class KthOfUnsortedArray implements Exercise {

	private final int SIZE = 10;
	private final int MAXIMUM = 500;
	
	private int k;
	private int result;
	private int[] array;
	private int[] reference;
	
	private void initialize() {
		array = new int[SIZE];
		reference = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			int num = (int) (Math.random() * MAXIMUM);
			array[i] = num;
			reference[i] = num;
		}
		
		Arrays.sort(reference);
	}
	
	@Override
	public void runExercise() {
		initialize();
		
		for (k = 1; k <= SIZE; k++) {
			if (k % 2 == 1) continue;

			int[] copy = Arrays.copyOf(array, array.length);
			result = getKth(copy , 0, array.length - 1, k);
			test();
		}
		
	}
	
	private int getKth(int[] array, int start, int end, int k) {
		if (start == end) return array[start];
		
		int pivotIndex = (int) (Math.random() * (end - start + 1)) + start;
		pivotIndex = partition(array, start, end, pivotIndex);
		
		if (k - 1 < pivotIndex) {
			return getKth(array, start, pivotIndex - 1, k);
		} else if (k - 1 > pivotIndex) {
			return getKth(array, pivotIndex + 1, end, k);
		} else {
			return array[pivotIndex];
		}
	}
	
	private int partition(int[] array, int start, int end, int k) {
		int index = start;
		int pivotValue = array[k];
		
		swap(array, k, end);
		for (int i = start; i <= end - 1; i++) {
			if (array[i] < pivotValue) {
				swap(array, i, index++);
			}
		}
		
		swap(array, index, end);
		return index;
	}
	
	private void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	private void test() {
		int answer = reference[k - 1];
		
		System.out.printf("The %dth element of the array is %d, %s%n", k, result, (result == answer)? "correct!" : "incorrect");
	}
}
