package com.cllin.leetcode;

import java.util.Arrays;

public class SingleNumberII implements LeetCodeExercise {
	private final int MAXIMUM = 100;
	private final int SIZE = 3;
	
	private int[] numbers;
	private int answer;
	private int result;

	@Override
	public void initialize() {
		numbers = new int[SIZE * 3 + 1];
		for(int i = 0; i < SIZE; i++){
			int value = numbers[i] = (int)(Math.random() * MAXIMUM);
			numbers[i] = value;
			numbers[i + SIZE] = value;
			numbers[i + SIZE + SIZE] = value;
		}
		
		int value = (int)(Math.random() * MAXIMUM);
		numbers[SIZE * 3] = value;
		answer = value;
	}

	@Override
	public void runExercise() {
		initialize();
		
		result = singleNumber(numbers);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
    private int singleNumber(int[] A) {
        int result = 0;
        int length = A.length;
        int[] count = new int[32];
        
        Arrays.fill(count, 0);
        
        if (length % 3 != 1) return -1;
        
        for (int i = 0; i < 32; i++) {
        	for (int j = 0; j < length; j++) {
        		count[i] += ((A[j] >> i) & 1);
        	}
        	
        	count[i] %= 3;
        	result |= count[i] << i;
        }
        
        return result;
    }

	@Override
	public boolean test() {
		return (result == answer)? true : false;
	}

}