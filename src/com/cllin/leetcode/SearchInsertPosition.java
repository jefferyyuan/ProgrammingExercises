package com.cllin.leetcode;

import java.util.Arrays;

public class SearchInsertPosition implements LeetCodeExercise {
	private final int MAXIMUM = 10;
	private final int SIZE = 10;
	
	private int[] integers;

	@Override
	public void initialize() {
		integers = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			integers[i] = (int)(Math.random() * MAXIMUM);
		}
		
		Arrays.sort(integers);
	}

	@Override
	public void runExercise() {
		test();
	}
	
    public int searchInsert(int[] A, int target) {
    	int position = -1;
    	int length = A.length;
    	
    	if (length < 1) return position;
    	if (target <= A[0]) return 0;
    	if (A[length - 1] < target) return length;
    	
    	for (int i = 0; i < length - 1; i++) {
    		if (A[i] < target && target <= A[i + 1]) return i + 1; 
    	}
    	
        return length;
    }

	@Override
	public boolean test() {
		for (int i = 0; i < 10; i++) {
			initialize();
			int target = (int)(Math.random() * MAXIMUM);
			int position = searchInsert(integers, target);
			
			for (int n : integers) {
				System.out.printf("%d ", n);
			}
			System.out.println();
			
			
			if (position == integers.length)
				System.out.printf("%d should be insert after %d%n", target, integers[position - 1]);
			else if (position == 0) 
				System.out.printf("%d should be insert before %d%n", target, integers[position]);
			else 
				System.out.printf("%d should be insert after %d and before %d%n", target, integers[position - 1], integers[position]);
			
			System.out.println("------------");
		}
		
		return true;
	}

}
