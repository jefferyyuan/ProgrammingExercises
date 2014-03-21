package com.cllin.sort;

/*
 * Worst case performance			:O(n ^ 2)
 * Best case performance			:O(n log n) (simple partition)
 * Average case performance			:O(n log n)
 * Worst case space complexity		:O(1) (in place)
 *
 * Reference						:http://en.wikipedia.org/wiki/Quicksort
 */

public class QuickSort extends Sort {
	protected void sort(){
		quickSort(numbers, 0, SIZE - 1);
	}
	
	private int partition(int[] numbers, int start, int end) {
		int x = numbers[end];
		int i = start - 1;
		
//		Swap if the element is smaller than the last element
		for (int j = start; j < end; j++) {
			if (numbers[j] <= x) {
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
	private int randomizedPartition(int[] numbers, int start, int end) {
		int index = (int)(Math.random() * (end -  start + 1)) + start;
		
//		Swap the random element and the last element
		int tmp = numbers[index];
		numbers[index] = numbers[end];
		numbers[end] = tmp;
		
		return partition(numbers, start, end);
	}
	
	private void quickSort(int[] numbers, int start, int end) {
		if (end > start) {
			int partitionIndex = partition(numbers, start, end);
//			int partitionIndex = randomizedPartition(start, end);
			quickSort(numbers, start, partitionIndex - 1);
			quickSort(numbers, partitionIndex, end);
		}
	}
}
