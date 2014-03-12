package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

public class SingleNumber implements LeetCodeExercise {
	private final int MAXIMUM = 100;
	private final int SIZE = 100;
	
	private int[] array;
	private int result;
	
	@Override
	public void initialize() {
		array = new int[SIZE * 2 + 1];
		for(int i = 0; i < SIZE; i++){
			int value = array[i] = (int)(Math.random() * MAXIMUM);
			array[i] = value;
			array[i + SIZE] = value;
		}
		
		array[SIZE * 2] = (int)(Math.random() * MAXIMUM);
	}

	@Override
	public void runExercise() {
		initialize();
		
		int length = array.length;
		int number = 0;
		for(int i = 0; i < length; i++){
			number ^= array[i];
		}
		result = number;

		if (test()) System.out.printf("%d is the single number%n", result);
		else System.out.println("Failed");
	}

	@Override
	public boolean test() {
		int single = -1;
		
		int length = array.length;
		int max = -1;
		for(int i = 0; i < length; i++){
			if (array[i] > max) max = array[i];
		}
		
		int[] counts = new int[max + 1];
		Arrays.fill(counts, 0);
		
		for(int i = 0; i < length; i++){
			counts[array[i]]++;
		}
		
		for(int i = 0; i <= max; i++){
			if (counts[i] % 2 == 1) single = i;
		}
		
		return (single == result)? true : false;
	}

}
