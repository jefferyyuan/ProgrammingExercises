package com.cllin.sort;

public class CountingSort extends Sort {
	protected void sort(){
		int max = getMaximum();
		int[] counts = new int[max + 1];
		int[] sorted = new int[SIZE];
		
		for(int i = 0; i < max + 1; i++){
			counts[i] = 0;
		}
		
		for(int i = 0; i < SIZE; i++){
			counts[numbers[i]]++;
		}
		
		for(int i = 1; i < max + 1; i++){
			counts[i] += counts[i - 1];
		}
		
		for(int i = SIZE - 1; i >= 0; i--){
			sorted[counts[numbers[i]] - 1] = numbers[i];
			counts[numbers[i]]--;
		}
		
		numbers = sorted;
	}
	
	private int getMaximum(){
		int max = 0;
		for(int i = 0; i < SIZE; i++){
			if (numbers[i] > max) max = numbers[i];
		}
		return max;
	}
}
