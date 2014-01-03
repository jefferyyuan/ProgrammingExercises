package com.cllin.sort;

public class InsertionSort extends Sort {
	protected void sort(){
		for (int i = 1; i < SIZE; i++) {
			int key = numbers[i];
			
			int j = i - 1;
			while (j >= 0 && numbers[j] > key) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			
			numbers[j + 1] = key;
		}
	}
}
