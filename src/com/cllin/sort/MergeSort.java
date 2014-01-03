package com.cllin.sort;

public class MergeSort extends Sort {
	protected void sort(){
		mergeSort(0, numbers.length - 1);
	}
	
	private void mergeSort(int start, int end){
		if(end > start){
			int mid = (end + start) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, mid, end);
		}
	}
	
	private void merge(int start, int mid, int end){
		int sizeOfFirstHalf = mid - start + 2;
		int sizeOfSecondHalf = end - mid + 1;
		int[] firstHalf = new int[sizeOfFirstHalf];
		int[] secondHalf = new int[sizeOfSecondHalf];
		
		firstHalf[sizeOfFirstHalf - 1] = 2147483647;
		for(int i = 0; i < sizeOfFirstHalf - 1; i++){
			firstHalf[i] = numbers[i + start];
		}
		
		secondHalf[sizeOfSecondHalf - 1] = 2147483647;
		for(int i = 0; i < sizeOfSecondHalf - 1; i++){
			secondHalf[i] = numbers[i + mid + 1];
		}
		
		int i = 0;
		int j = 0;
		for(int k = start; k < end + 1; k++){
			if(firstHalf[i] <= secondHalf[j]){
				numbers[k] = firstHalf[i];
				i++;
			}else{
				numbers[k] = secondHalf[j];
				j++;
			}
		}
	}
}
