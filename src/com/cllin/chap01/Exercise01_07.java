package com.cllin.chap01;

import java.util.ArrayList;

import com.cllin.main.Exercise;

public class Exercise01_07 implements Exercise {
	private final int SIZE_M = 1000;
	private final int SIZE_N = 900;
	private int[][] matrix;

	@Override
	public void runExercise() {
		initialize();
		setZero();
	}
	
	private void setZero(){
		ArrayList<Integer> rowsToBeZero = new ArrayList<Integer>();
		ArrayList<Integer> columnsToBeZero = new ArrayList<Integer>();
		
		for(int i = 0; i < SIZE_M; i++){
			for(int j = 0; j < SIZE_N; j++){
				if(matrix[i][j] == 0){
					rowsToBeZero.add(i);
					columnsToBeZero.add(j);
				}
			}
		}
		
		for(int rows : rowsToBeZero){
			for(int j = 0; j < SIZE_N; j++){
				matrix[rows][j] = 0;
			}
		}
		
		for(int cols : columnsToBeZero){
			for(int i = 0; i < SIZE_M; i++){
				matrix[i][cols] = 0;
			}
		}
	}
	
	private void initialize(){
		matrix = new int[SIZE_M][SIZE_N];
		for(int i = 0; i < SIZE_M; i++){
			for(int j = 0; j < SIZE_N; j++){
				matrix[i][j] = getRandomNumber();
			}
		}
	}
	
	private int getRandomNumber(){
		return (Math.random() < 0.3)? 0 : 1;
	}

}
