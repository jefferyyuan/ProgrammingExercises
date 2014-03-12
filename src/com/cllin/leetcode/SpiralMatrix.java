package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

public class SpiralMatrix implements LeetCodeExercise {

	private final int[][][] testSuite = {
			{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
			},
			{
				{1, 2, 3}
			}, 
			{
				{1},
				{2},
				{3}
			}, {
				{2, 5, 8},
				{4, 0, -1}
			}
	};
	
	private int index;
	private ArrayList<Integer> output;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			int rows = testSuite[index].length;
			int cols = testSuite[index][0].length;
			
			int[][] matrix = new int[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					matrix[i][j] = testSuite[index][i][j];
				}
			}
			
			output = spiralOrder(matrix);
			test();
		}
	}
	
	int goRight = 1;
	int goDown = 2;
	int goLeft = 3;
	int goUp = 4;
	private ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> output = new  ArrayList<Integer>();
		
		if (matrix == null || matrix.length == 0) return output;
		
		int index = -1;
		while (!isFinished(matrix, index)) {
			index = goRightOrLeft(output, matrix, goRight, index);
			index = goUpOrDown(output, matrix, goDown, index);
			index = goRightOrLeft(output, matrix, goLeft, index);
			index = goUpOrDown(output, matrix, goUp, index);
		}
		
		return output;
    }
	
	private int goRightOrLeft(ArrayList<Integer> output, int[][] matrix, int flag, int index) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int delta = (flag == goRight)? 1 : -1;
		
		int i = index / cols;
		int j = index % cols + delta;
		if (index == -1) {
			i = 0;
			j = 0;
		}
		
		while (0 <= j && j < cols && i < rows && matrix[i][j] != -2147483648) {
			output.add(matrix[i][j]);
			matrix[i][j] = -2147483648;
			j += delta;
		}
		
		return i * cols + (j - delta);
	}
	
	private int goUpOrDown(ArrayList<Integer> output, int[][] matrix, int flag, int index) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int delta = (flag == goDown)? 1 : -1;
		
		int i = index / cols + delta;
		int j = index % cols;
		
		while (0 <= i && i < rows && j < cols && matrix[i][j] != -2147483648) {
			output.add(matrix[i][j]);
			matrix[i][j] = -2147483648;
			i += delta;
		}
		
		return (i - delta) * cols + j;
	}
	
	private boolean isFinished(int[][] matrix, int index) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] != -2147483648) return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean test() {
		System.out.print("For the matrix:\n");
		
		int[][] matrix = testSuite[index];
		for (int[] row : matrix) {
			for (int n : row) {
				System.out.printf("%d ", n);
			}
			System.out.println();
		}
		
		System.out.print("The elements is spiral order are displayed as: ");
		
		for (int n : output) System.out.printf("%d ", n);
		
		System.out.println("\n------------------");
		
		return false;
	}

}
