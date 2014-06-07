package com.cllin.cci.chap08;

import com.cllin.main.Exercise;

/*
 * Write an algorithm to print all ways of arranging eight queens on a chess board,
 * so that none of them share the same row, column or diagonal.
 */

public class Exercise08_08 implements Exercise {
	private boolean[][] chessBoard;
	private int count;
	private Pair[] pairs = new Pair[8];

	@Override
	public void runExercise() {
		initialize();
		
		for (int i = 0; i < 8; i++) {
			count = 0;
			initialize();
			placeQueen(i, 0);
			
//			PRINT SOLUTION
			if(count == 8){
				System.out.println("-------------------------");
				for (int j = 0; j < count; j++) {
					System.out.print(" (" + pairs[j].x + "," + pairs[j].y + ")");
					if (j == 3) System.out.println();
					
					chessBoard[(int)pairs[j].x][(int)pairs[j].y] = true;
				}
				
				printBoard(chessBoard);
				System.out.println("-------------------------");
			}
		}
		
	}
	
	private void placeQueen(int x, int y) {
		chessBoard[x][y] = false;
		pairs[count] = new Pair(x, y);
		count++;
		
		for (int i = 0; i < 8; i++) {
			chessBoard[x][i] = false;
			chessBoard[i][y] = false;
			for (int j = 0; j < 8; j++) {
				if (Math.abs(x - i) == Math.abs(y - j)) {
					chessBoard[i][j] = false;
				}
			}
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(chessBoard[i][j]){
					placeQueen(i, j);
				}
			}
		}
	}
	
	private void initialize() {
		chessBoard = new boolean[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				chessBoard[i][j] = true;
			}
		}
	}
	
	private void printBoard(boolean[][] chessBoard) {
		System.out.println();
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print((chessBoard[i][j])? " o" : " x");
			}
			System.out.println();
		}
	}

	private class Pair {
		private int x;
		private int y;
		private Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
