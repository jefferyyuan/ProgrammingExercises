package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

public class SearchInRotatedSortedArray implements LeetCodeExercise {
	private final int MAXIMUM = 200;
	private final int SIZE = 100;
	
	private int[] numbers;
	private int target;
	private int result;
	
	@Override
	public void initialize() {
		result = -1;
		target = (int) (Math.random() * MAXIMUM);
		
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < SIZE; i++) {
			tmp.add((int) (Math.random() * MAXIMUM));
		}
		
		for (int i = 0; i < tmp.size(); i++) {
			for (int j = i + 1; j < tmp.size(); j++) {
				if (tmp.get(i).intValue() == tmp.get(j).intValue()) tmp.remove(j);
			}
		}
		
		int size = tmp.size();
		int[] buf = new int[size];
		for (int i = 0; i < size; i++) {
			buf[i] = tmp.get(i).intValue();
		}
		
		Arrays.sort(buf);
		
		int pivot = (int) (Math.random() * size);
		numbers = new int[size];
		
		for (int i = 0; i < size; i++) {
			if (i < size - pivot) numbers[i] = buf[i + pivot];
			else numbers[i] = buf[i - size + pivot];
		}
	}

	@Override
	public void runExercise() {
		for (int i = 0; i < 10; i++) {
			initialize();
			
			result = search(numbers, target);
			if (test()) System.out.println("Success");
			else System.out.println("Failed");	
		}
	}
	
    private int search(int[] numbers, int target) {
    	int index = -1;
    	int length = numbers.length;
    	
    	if (length == 0) return index;
    	else if (length == 1) return (numbers[0] == target)? 0 : index;
    	
    	if (target < numbers[0]) {
    		for (int i = length - 1; i >= 0; i--) {
    			if (target == numbers[i]) return i; 
    			else if (target > numbers[i]) return index;
    			
    			if (i > 0 && numbers[i] < numbers[i - 1]) break;
    		}
    	} else if (target > numbers[0]) {
    		for (int i = 0; i <= length - 1; i++) {
    			if (target == numbers[i]) return i; 
    			else if (target < numbers[i]) return index;
    			
    			if (i < length - 1 && numbers[i] > numbers[i + 1]) break;
    		}
    	} else {
    		return 0;
    	}
    	
    	return index;
    }

	@Override
	public boolean test() {
		int index = -1;
		int length = numbers.length;
		
		for (int i = 0; i < length; i++) {
			if (numbers[i] == target) {
				index = i;
				break;
			}
		}
		
		return (index == result)? true : false;
	}
}
