package com.cllin.chap9;

import com.cllin.main.Exercise;

public class Exercise09_03 implements Exercise {
	private final int SIZE = 10;
	private final int MAXIMUM = 10000;
	
	private int[] array;
	
	@Override
	public void runExercise() {
		initialize();
		
		int[] testSuite = new int[10];
		for(int i = 0; i < 10; i++){
			testSuite[i] = (int)(Math.random() * MAXIMUM);
		}
		
		for(int i = 0; i < 10; i++){
			int key = find(testSuite[i]);
			if(key != -1){
				System.out.println(testSuite[i] + " is found at #" + key);
			}else{
				System.out.println(testSuite[i] + " is not found");
			}
		}
	}
	
	private int find(int value){
//		TODO
		return binarySearch(value, 0, SIZE - 1);
	}
	
	private int binarySearch(int value, int low, int high){
		int key = -1;
//		TODO
		return key;
	}
	
	private void initialize(){
		array = new int[SIZE];
		
		for(int i = 0; i < SIZE; i++){
			array[i] = (int)(Math.random() * MAXIMUM);
		}
		
		sort();
		rotate();
	}
	
	private void rotate(){
		int key = (int)(Math.random() * SIZE);
		int[] buf = new int[SIZE];
		
		for(int i = 0; i < SIZE; i++){
			buf[i] = array[i];
		}
		
		for(int i = 0; i < SIZE - key; i++){
			array[i] = buf[key + i];
		}
		
		for(int i = SIZE - key; i < SIZE; i++){
			array[i] = buf[i - SIZE + key];
		}
	}
	
	private void sort(){
		int[] counts = new int[MAXIMUM + 1];
		int[] sorted = new int[SIZE];
		
		for(int i = 0; i < MAXIMUM + 1; i++){
			counts[i] = 0;
		}
		
		for(int i = 0; i < SIZE; i++){
			counts[array[i]]++;
		}
		
		for(int i = 1; i < MAXIMUM + 1; i++){
			counts[i] += counts[i - 1];
		}
		
		for(int i = SIZE - 1; i >= 0; i--){
			sorted[counts[array[i]] - 1] = array[i];
			counts[array[i]]--;
		}
		
		array = sorted;
	}

}
