package com.cllin.cci.chap08;

import com.cllin.main.Exercise;

public class Exercise08_08 implements Exercise {
	private boolean[][] chessBoard;
	private int count;
	@SuppressWarnings("rawtypes")
	private Pair[] pairs = new Pair[8];

	@Override
	public void runExercise() {
		initialize();
		
		for(int i = 0; i < 8; i++){
			count = 0;
			initialize();
			placeQueen(i, 0);
			
//			PRINT SOLUTION
			if(count == 8){
				System.out.println("-----");
				for(int j = 0; j < count; j++){
					System.out.print(" (" + pairs[j].x + "," + pairs[j].y + ")");
					if (j == 3) System.out.println();
					
					chessBoard[(int)pairs[j].x][(int)pairs[j].y] = true;
				}
				
				printBoard();
				System.out.println("-----");
			}
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void placeQueen(int x, int y){
		chessBoard[x][y] = false;
		pairs[count] = new Pair(x, y);
		count++;
		
		for(int i = 0; i < 8; i++){
			chessBoard[x][i] = false;
			chessBoard[i][y] = false;
			for(int j = 0; j < 8; j++){
				if(Math.abs(x - i) == Math.abs(y - j)){
					chessBoard[i][j] = false;
				}
			}
		}
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(chessBoard[i][j]){
					placeQueen(i, j);
				}
			}
		}
	}
	
	private void initialize(){
		chessBoard = new boolean[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				chessBoard[i][j] = true;
			}
		}
	}
	
	private void printBoard(){
		System.out.println();
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(chessBoard[i][j]){
					System.out.print(" o");
				}else{
					System.out.print(" x");
				}
			}
			System.out.println();
		}
	}

	private class Pair<T>{
		private T x;
		private T y;
		private Pair(T x, T y){
			this.x = x;
			this.y = y;
		}
	}
}
