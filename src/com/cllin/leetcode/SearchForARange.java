package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

public class SearchForARange implements LeetCodeExercise {
	private final int SIZE = 10;
	private final int MAXIMUM = 10;
	
	private int target;
	private int[] numbers;
	private int[] result;

	@Override
	public void initialize() {
		target = (int) (Math.random() * MAXIMUM);
		
		numbers = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			numbers[i] = (int) (Math.random() * MAXIMUM);
		}
		
		Arrays.sort(numbers);
	}

	@Override
	public void runExercise() {
		for (int i = 0; i < 100; i++) {
			initialize();
			result = searchRange(numbers, target);
			
			if (test()) System.out.println("Success");
			else System.out.println("Failed");
		}
	}
	
	private int[] searchRange(int[] array, int target) {
		int[] range = new int[]{-1, -1};
		int length = array.length;
		
		if (length == 0) return range;
		
		int begin = -1;
		int end = -1;
		
		if (array[0] == target) begin = 0;
		else if (target < array[0]) begin = -1;
		else {
			for (int n = target - 1;;n--) {
				int index = binarySearch(array, n, 0, length);
				if (index != -1) {
					for (int i = index; i < length; i++) {
						if (array[i] == target) {
							begin = i;
							break;
						}
					}
					break;
				}
			}
		}
		
		if (array[length - 1] == target) end = length - 1;
		else if (array[length - 1] < target) end = -1;
		else {
			for (int n = target + 1;;n++) {
				int index = binarySearch(array, n, 0, length);
				if (index != -1) {
					for (int i = index; i >= 0; i--) {
						if (array[i] == target) {
							end = i;
							break;
						}
					}
					break;
				}
			}
		}
		
		range = new int[]{begin, end};
    	return range;
    }
	
	private int binarySearch(int[] array, int target, int start, int end) {
    	if (start == end) return (array[start] == target)? start : -1;
    	else if (start > end) return -1;
    	
    	int mid = (start + end) / 2;
    	
    	if (target == array[mid]) return mid;
    	else if (target < array[mid]) return binarySearch(array, target, start, mid - 1);
    	else return binarySearch(array, target, mid + 1, end);
	}

	@Override
	public boolean test() {
		int begin = -1;
		int end = -1;
		ArrayList<Integer> range = new ArrayList<Integer>();
		for (int i = 0; i < SIZE; i++) {
			if (numbers[i] == target) range.add(i);
		}
		
		if (range.size() != 0) {
			begin = range.get(0);
			end = range.get(range.size() - 1);
		}
		
		return (result[0] == begin && result[1] == end)? true : false;
	}

}
