package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * Source: http://oj.leetcode.com/problems/n-queens-ii/
 */

public class NQueensII implements LeetCodeExercise {

	private int result;
	private int N;
	
	@Override
	public void initialize() {
		result = 0;
	}

	@Override
	public void runExercise() {
		initialize();
		
		for (int n = 0; n <= 10; n++) {
			N = n;
			result = totalNQueens(n);
			test();
		}
	}
	
	private int totalNQueens(int n) {
		if (n < 1) return 0;

		boolean[][] chessBoard = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) chessBoard[i][j] = true; 
		}
		
		return placeQueen(0, n, chessBoard);
    }
	
	private int placeQueen(int col, int n, boolean[][] chessBoard){
		if (col == n) return 1;
		int result = 0;

		for (int i = 0; i < n; i++) {
			if (isSafe(i, col, n, chessBoard)) {
				
				chessBoard[i][col] = false;
				result += placeQueen(col + 1, n, chessBoard);
				
				if (result == 1) {
					for (int p = 0; p < n; p++) {
						for (int q = col; q < n; q++) chessBoard[p][q] = true;
					}
				} else {
					chessBoard[i][col] = true;
				}
			}
		}
		
		return result;
	}
	
	private boolean isSafe(int x, int y, int n, boolean[][] chessBoard) {
		int i, j;
		
		for (i = x; i >= 0; i--) if (!chessBoard[i][y]) return false; 
		for (j = y; j >= 0; j--) if (!chessBoard[x][j]) return false; 
		for (i = x, j = y; i >= 0 && j >= 0; i--, j--) if (!chessBoard[i][j]) return false; 
		for (i = x, j = y; i < n && j >= 0; i++, j--) if (!chessBoard[i][j]) return false; 
		
		return true;
	}

	@Override
	public boolean test() {
		System.out.printf("There are %d distinct solutions for a %d-queens problem%n", result, N);
		return false;
	}
}
