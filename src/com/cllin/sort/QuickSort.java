package com.cllin.sort;

/*
 * Worst case performance			:O(n ^ 2)
 * Best case performance			:O(n log n) (simple partition)
 * Average case performance			:O(n log n)
 * Worst case space complexity		:O(1) (in place)
 */

public class QuickSort extends Sort {
	protected void sort(){
		quickSort(numbers, 0, SIZE - 1);
	}
	
	private void quickSort(int[] array, int start, int end) {
		if (end > start) {
			int partitionIndex = partition(array, start, end);
			
			quickSort(array, start, partitionIndex - 1);
			quickSort(array, partitionIndex, end);
		}
	}
	
	private int partition(int[] array, int start, int end) {
//		Pivotal index is end here, it can also be selected randomly
		int x = array[end];
		int index = start - 1;
		
//		Swap if the element is smaller than the last element, x
		for (int j = start; j < end; j++) {
			if (array[j] <= x) {
				index++;
				swap(index, j, array);
			}
		}

//		Every element before i (inclusive) is smaller than x
		swap(index + 1, end, array);
		
//		Every element after i + 1 is larger than x
		return index + 1;
	}
	
	private void swap(int i, int j, int[] array) {
		int tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}
	
	@SuppressWarnings("unused")
	private int randomizedPartition(int[] array, int start, int end) {
		int index = (int)(Math.random() * (end -  start + 1)) + start;
		
//		Swap the random element and the last element
		int tmp = array[index];
		array[index] = array[end];
		array[end] = tmp;
		
		return partition(array, start, end);
	}
}
