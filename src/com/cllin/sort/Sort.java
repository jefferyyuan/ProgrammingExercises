package com.cllin.sort;

import com.cllin.main.Exercise;

public class Sort implements Exercise {
	private final int MAXIMUM = 10000;
	protected final int SIZE = 10000;
	protected int[] numbers = new int[SIZE];

	@Override
	public void runExercise() {
		initialization();
		
		long start = System.nanoTime();
		sort();
		long end = System.nanoTime();
		
		test();
		
		System.out.println("It took " + (double) ((end - start) / 1000000) 
				+ "ms to sort " + SIZE + " integers");
	}
	
	private void initialization(){
		int length = numbers.length;
		for(int i = 0; i < length; i++){
			numbers[i] = (int)(Math.random() * MAXIMUM);
		}
	}
	
	private void test(){
		for(int i = 0; i < SIZE - 1; i++){
			if(numbers[i] > numbers[i + 1]){
				System.out.println("Failed");
				return;
			}
		}
		System.out.println("The sequence is sorted");
	}

	protected void sort(){
//		WILL BE OVERRIDDEN
	};
}
