package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseInteger implements LeetCodeExercise {
	private final int MAXIMUM = (1 << 30) - 1 + (1 << 30);
	private final int SIZE = 5;
	
	private int[] integers;
	private int[] results;

	@Override
	public void initialize() {
		integers = new int[SIZE];
		results = new int[SIZE];
		
		Arrays.fill(results, 0);
		
		for(int i = 0; i < SIZE; i++){
			int value = (int)(Math.random() * MAXIMUM) + 1;
			if (Math.random() > 0.5) value *= -1;
			
			integers[i] = value;
		}
	}

	@Override
	public void runExercise() {
		initialize();
		
		for(int i = 0; i < SIZE; i++){
			results[i] = reverse(integers[i]);
			System.out.printf("The reverse of %d is %d%n", integers[i], results[i]);
		} 
		
	}
	
	private int reverse(int x){
		ArrayList<Integer> digits = new ArrayList<Integer>();
		boolean isNegative = false;
		
		if (x == 0) return 0;
		if (x < 0) {
			isNegative = true;
			x *= -1;
		}
		
		while(x > 0){
			digits.add(x % 10);
			x = (x - x % 10) / 10;
		}
		
		int size = digits.size();
		int result = 0;
		
		for(int i = 0; i < size; i++){
			if (result + digits.get(i) * Math.pow(10, (size - i - 1)) > MAXIMUM) return 0;
			
			result += digits.get(i) * Math.pow(10, (size - i - 1));
		}
		
		return (isNegative)? result * (-1) : result;
	}

	@Override
	public boolean test() {
		return true;
	}

}
