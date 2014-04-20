package com.cllin.sort;

/*
 * Average case performance			:O(n log n)
 * Worst case space complexity		:O(n)
 */

public class MergeSort extends Sort {
	protected void sort(){
		mergeSort(numbers, 0, numbers.length - 1);
	}
	
	private void mergeSort(int[] array, int start, int end) {
		if (end > start) {
			int mid = (end + start) / 2;
			
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}
	
	private void merge(int[] array, int start, int mid, int end) {
		int left = start;
		int right = mid + 1;
		int[] temp = new int[end - start + 1];
		
		for (int i = 0; i < temp.length; i++) {
			if (left > mid || (right <= end && array[left] >= array[right])) {
				temp[i] = array[right++];
				continue;
			}
			
			if (right > end || (left <= mid && array[left] < array[right])) {
				temp[i] = array[left++];
				continue;
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			array[start + i] = temp[i];
		}
	}
}
