package com.cllin.sort;

import com.cllin.main.Exercise;

public class Sort implements Exercise {
	private final int MAXIMUM = 100;
	protected final int SIZE = 100;
	protected int[] numbers = new int[SIZE];

	@Override
	public void runExercise() {
		initialize();
		
		long start = System.nanoTime();
		sort();
		long end = System.nanoTime();
		
		test();
		
		System.out.printf("It took %f ms to sort %d integers%n", (float) ((end - start) / 1E6), SIZE);
	}
	
	private void initialize() {
		int length = numbers.length;
		for (int i = 0; i < length; i++) {
			numbers[i] = (int) (Math.random() * MAXIMUM);
		}
	}
	
	private void test() {
		for (int i = 0; i < SIZE - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				System.out.println("Failed");
				return;
			}
		}
		System.out.println("The sequence is sorted");
	}
	
	protected void printArray(){
		System.out.println("The array is:");
		System.out.print("\t");
		for (int i = 0; i < SIZE; i++) {
			System.out.printf("%d ", numbers[i]);
		}
		System.out.println();
	}

	protected void sort(){
//		TODO
//		WILL BE OVERRIDDEN
	};
}
