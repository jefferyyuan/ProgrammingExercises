package com.cllin.leetcode;

public class SortColors implements LeetCodeExercise {
	private final int MAXIMUM = 3;
	private final int SIZE = 1000;
	
	private int[] numbers;
	
	@Override
	public void initialize() {
		numbers = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			numbers[i] = (int)(Math.random() * MAXIMUM);
		}
	}

	@Override
	public void runExercise() {
		initialize();
		
		numbers = sortColors(numbers);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
    private int[] sortColors(int[] A) {
    	int length = A.length;
    	if (length == 0) return null;
    	
    	int[] counts = {0, 0, 0};
    	
    	for (int i = 0; i < length; i++) counts[A[i]]++;

    	int firstBound = counts[0];
    	int secondBound = counts[0] + counts[1];
    	
    	for (int i = 0; i < length; i++) {
    		if (i < firstBound) A[i] = 0;
    		else if (i < secondBound) A[i] = 1;
    		else A[i] = 2;
    	}
    	
        return A;
    }

	@Override
	public boolean test() {
		for (int i = 1; i < SIZE; i++) {
			if (numbers[i] < numbers[i - 1]) return false;
		}
		
		return true;
	}

}
