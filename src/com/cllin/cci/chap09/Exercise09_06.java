package com.cllin.cci.chap09;

import com.cllin.main.Exercise;

public class Exercise09_06 implements Exercise {
	private final int ROW = 1000;
	private final int COLUMN = 1000;
	private final int SIZE = ROW * COLUMN;
	private final int MAXIMUM = 10000;
	
	private int[] unsorted;
	private int[][] matrix;
	
	@Override
	public void runExercise() {
		initialize();
		
		for(int i = 0; i < 10; i++){
			int value = (int)(Math.random() * MAXIMUM);
			int key = find(value);
			if(key == -1){
				System.out.println(value + " cannot be found");
			}else{
				int col = key % ROW;
				int row = (key - col) / ROW;
				System.out.println(value + " is found at (" + row + "," + col + ")");
			}
		}

	}
	
	private int find(int number){
		int row = 0;
		for(int i = 0; i < ROW; i++){
			if(matrix[i][0] > number){
				row = i;
				break;
			}else if(matrix[i][0] == number){
				return i * ROW;
			}
		}
		
		for(int i = 0; i < COLUMN; i++){
			if(matrix[row][i] == number){
				return row * ROW + i;
			}			
		}
		
		return -1;
	}
	
	private void initialize(){
		unsorted = new int[SIZE];
		matrix = new int[ROW][COLUMN];
		
		for(int i = 0; i < SIZE; i++){
			unsorted[i] = (int)(Math.random() * MAXIMUM);
		}
		
		sort();
		
		for(int i = 0; i < ROW; i++){
			for(int j = 0; j < COLUMN; j++){
				matrix[i][j] = unsorted[i * ROW + j];
			}
		}
		
	}
	
	private void sort(){
		int[] counts = new int[MAXIMUM + 1];
		int[] sorted = new int[SIZE];
		
		for(int i = 0; i < MAXIMUM + 1; i++){
			counts[i] = 0;
		}
		
		for(int i = 0; i < SIZE; i++){
			counts[unsorted[i]]++;
		}
		
		for(int i = 1; i < MAXIMUM + 1; i++){
			counts[i] += counts[i - 1];
		}
		
		for(int i = SIZE - 1; i >= 0; i--){
			sorted[counts[unsorted[i]] - 1] = unsorted[i];
			counts[unsorted[i]]--;
		}
		
		unsorted = sorted;
	}
}
