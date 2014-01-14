package com.cllin.chap01;

import com.cllin.main.Exercise;

public class Exercise01_06 implements Exercise {
	private final int SIZE = 5;
	private final int MAXIMUM = 1000;
	private int[][] matrix;
	private int[][] reference;
	
	@Override
	public void runExercise() {
		initialize();
		rotate();
		test();
	}
	
	private void rotate(){
		for(int i = 0; i < SIZE; i++){
			for(int j = i + 1; j < SIZE; j++){
				if(i != j){
					int buf = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = buf;
				}
			}
		}
		
		int bound = SIZE / 2;
		for(int i = 0; i < bound; i++){
			for(int j = 0; j < SIZE; j++){
				int buf = matrix[i][j];
				matrix[i][j] = matrix[SIZE - i - 1][j];
				matrix[SIZE - i - 1][j] = buf;
			}
		}
	}
	
	private void test(){
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				if(matrix[i][j] != reference[j][SIZE - i - 1]){
					System.out.println("Failed");
					return;
				}
			}
		}
		System.out.println("Success!");
	}
	
	private void initialize(){
		matrix = new int[SIZE][SIZE];
		reference = new int[SIZE][SIZE];
		
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				int n = (int)(Math.random() * MAXIMUM);
				matrix[i][j] = n;
				reference[i][j] = n;
			}
		}
	}

}
