package com.cllin.sort;

/*
 * Average case performance			:O(n log n)
 * Worst case space complexity		:O(1) (in place)
 */

public class HeapSort extends Sort {
	protected void sort(){
		heapSort(numbers);
	}
	
	private void heapSort(int[] array) {
		int length = array.length;
		
		buildMaxHeap(array, length);
		for (int i = length - 1; i >= 1; i--) {
			int tmp = array[i];
			array[i] = array[0];
			array[0] = tmp;
			maxHeapify(array, 0, i - 1);
		}
	}
	
	private void buildMaxHeap(int[] array, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapify(array, i, n);
		}
	}
	
	private void maxHeapify(int[] array, int i, int n) {
//		l, r are the index of the children nodes
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		
		if (r > array.length - 1) return;
		
		if (l <= n && array[l] > array[i]) largest = l;
		if (r <= n && array[r] > array[largest]) largest = r;

//		The parent node should be larger than its children
		if (largest != i) {
			int tmp = array[i];
			array[i] = array[largest];
			array[largest] = tmp;
			
			maxHeapify(array, largest, n);
		}
	}
}
