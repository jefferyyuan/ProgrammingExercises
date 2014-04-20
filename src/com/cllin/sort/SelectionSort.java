package com.cllin.sort;

/*
 * Average case performance			:O(n log n)
 * Worst case space complexity		:O(1) (in place)
 */

public class SelectionSort extends Sort {
	protected void sort(){
		selectionSort(numbers);
	}
	
	private void selectionSort(int[] array) {
		int length = array.length;
		
		for (int i = 0; i < length; i++) {
			int minIndex = i;
			
			for (int j = i; j < length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}
}
