package com.cllin.sort;


public class HeapSort extends Sort {
	protected void sort(){
		buildMaxHeap(SIZE);
		for(int i = SIZE - 1; i >= 1; i--){
			int tmp = numbers[i];
			numbers[i] = numbers[0];
			numbers[0] = tmp;
			maxHeapify(0, i - 1);
		}
	}
	
	private void buildMaxHeap(int n){
		for(int i = n / 2 - 1; i >= 0; i--){
			maxHeapify(i, n);
		}
	}
	
	private void maxHeapify(int i, int n){
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		
		if (r > SIZE - 1) return;
		
		if (l <= n && numbers[l] > numbers[i]) largest = l;
		if (r <= n && numbers[r] > numbers[largest]) largest = r;
		
		if(largest != i){
			int tmp = numbers[i];
			numbers[i] = numbers[largest];
			numbers[largest] = tmp;
			maxHeapify(largest, n);
		}
	}
}
