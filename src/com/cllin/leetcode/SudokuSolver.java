package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 * Source: http://oj.leetcode.com/problems/sudoku-solver/
 */

public class SudokuSolver implements LeetCodeExercise {

	private char[][][] testSuite = {
			{
				{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, 
				{'7', '.', '.', '.', '.', '.', '.', '.', '.'}, 
				{'.', '2', '.', '1', '.', '9', '.', '.', '.'}, 
				{'.', '.', '7', '.', '.', '.', '2', '4', '.'}, 
				{'.', '6', '4', '.', '1', '.', '5', '9', '.'}, 
				{'.', '9', '8', '.', '.', '.', '3', '.', '.'}, 
				{'.', '.', '.', '8', '.', '3', '.', '2', '.'}, 
				{'.', '.', '.', '.', '.', '.', '.', '.', '6'}, 
				{'.', '.', '.', '2', '7', '5', '9', '.', '.'}
			}
			
	};
	
	private int index;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		for (index = 0; index < testSuite.length; index++) {
			solveSudoku(testSuite[index]);
			
			test();
		}
	}
	
	private void solveSudoku(char[][] board) {
		if (board == null) return;
		if (board.length == 0 || board.length != board[0].length) return;
		
		solve(board, 0);
    }
	
	private boolean solve(char[][] board, int index) {
		int length = board.length;
		if (index == length * length) return true;
		
		int row = index / length;
		int col = index % length;
		
		if (board[row][col] != '.') return solve(board, index + 1);
		
		for (int i = 1; i <= length; i++) {
			board[row][col] = Character.forDigit(i,10);;
			
			if (isValid(board, row, col)) {
				if (solve(board, index + 1)) return true;
			}
			
			board[row][col] = '.';
		}
		
		return false;
	}
	
	private boolean isValid(char[][] board, int i, int j) {
		int length = board.length;
		int gridSize = (int) Math.sqrt(length);
		
//		Check by rows and columns 
		for (int m = 0; m < length; m++) {
			if (m != i) {
				if (board[m][j] == board[i][j]) {
					return false;
				}
			}
			
			if (m != j) {
				if (board[i][m] == board[i][j]) {
					return false;
				}
			}						
		}
		
//		Check by grid
		int startX = i / gridSize;
		int startY = j / gridSize;
		for (int m = 0; m < gridSize; m++) {
			for (int n = 0; n < gridSize; n++) {
				int x = startX * gridSize + m;
				int y = startY * gridSize + n;
				
				if (x != i && y != j) {
					if (board[x][y] == board[i][j]) {
						return false;
					}
				}
			}
		}
		
		return true;
	}

	@Override
	public boolean test() {
		System.out.println("The solution is:");
		
		for (char[] col : testSuite[index]) {
			for (char c : col) {
				System.out.printf("%c ", c);
			}
			System.out.println();
		}
		
		System.out.println("------------------");
		
		return true;
	}

}
