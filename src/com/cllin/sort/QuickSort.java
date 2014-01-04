package com.cllin.sort;

public class QuickSort extends Sort {
	protected void sort(){
		quickSort(0, SIZE - 1);
	}
	
	private int partition(int start, int end){
		int x = numbers[end];
		int i = start - 1;
		
		for(int j = start; j < end; j++){
			if(numbers[j] <= x){
				i++;
				int tmp = numbers[j];
				numbers[j] = numbers[i];
				numbers[i] = tmp;
			}
		}
		
		int tmp = numbers[i + 1];
		numbers[i + 1] = numbers[end];
		numbers[end] = tmp;
		
		return i + 1;
	}
	
	@SuppressWarnings("unused")
	private int randomizedPartition(int start, int end){
		int i = (int)(Math.random() * (end -  start + 1)) + start;
		
		int tmp = numbers[i];
		numbers[i] = numbers[end];
		numbers[end] = tmp;
		
		return partition(start, end);
	}
	
	private void quickSort(int start, int end){
		if(end > start){
			int partitionIndex = partition(start, end);
//			int partitionIndex = randomizedPartition(start, end);
			quickSort(start, partitionIndex - 1);
			quickSort(partitionIndex, end);
		}
	}
}
