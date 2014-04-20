package com.cllin.sort;

/*
 * Average case performance			:O(n ^ 2)
 * Worst case space complexity		:O(1) (in place)
 */

public class InsertionSort extends Sort {
	protected void sort(){
		insertionSort(numbers);
	}
	
	private void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			
			int j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			
			array[j + 1] = key;
		}
	}
}
