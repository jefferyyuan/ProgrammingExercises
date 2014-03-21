package com.cllin.sort;

/*
 * Worst case performance			:O(n log n)
 * Best case performance			:O(n log n)
 * Average case performance			:O(n log n)
 * Worst case space complexity		:O(1) (in place)
 *
 * Reference						:http://en.wikipedia.org/wiki/Heapsort
 */

public class HeapSort extends Sort {
	protected void sort(){
		heapSort(numbers);
	}
	
	private void heapSort(int[] numbers) {
		int length = numbers.length;
		
		buildMaxHeap(numbers, length);
		for (int i = length - 1; i >= 1; i--) {
			int tmp = numbers[i];
			numbers[i] = numbers[0];
			numbers[0] = tmp;
			maxHeapify(numbers, 0, i - 1);
		}
	}
	
	private void buildMaxHeap(int[] numbers, int n){
		for(int i = n / 2 - 1; i >= 0; i--){
			maxHeapify(numbers, i, n);
		}
	}
	
	private void maxHeapify(int[] numbers, int i, int n){
//		l, r are the index of the children nodes
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		
		if (r > numbers.length - 1) return;
		
		if (l <= n && numbers[l] > numbers[i]) largest = l;
		if (r <= n && numbers[r] > numbers[largest]) largest = r;

//		The parent node should be larger than its children
		if (largest != i) {
			int tmp = numbers[i];
			numbers[i] = numbers[largest];
			numbers[largest] = tmp;
			
			maxHeapify(numbers, largest, n);
		}
	}
}
