package com.cllin.leetcode;

import java.util.ArrayList;

public class ValidSudoku implements LeetCodeExercise {

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runExercise() {
		isValidSudoku(new char[0][0]);
	}
	
	private boolean isValidSudoku(char[][] board) {
		if (board.length == 0 || board.length != board[0].length) return false;
		
		int length = board.length;
		
		for (int i = 0; i < length; i++) {
			ArrayList<Boolean> taken = new ArrayList<Boolean>(length);
			for (int p = 1; p <= length; p++) taken.add(false);
			
			for (int j = 0; j < length; j++) {
				if (board[i][j] != '.') {
					int num = Character.getNumericValue(board[i][j]);
					if (taken.get(num - 1)) return false;
					taken.set(num - 1, true);
				}
			}
		}
		
		for (int j = 0; j < length; j++) {
			ArrayList<Boolean> taken = new ArrayList<Boolean>(length);
			for (int p = 1; p <= length; p++) taken.add(false);
			
			for (int i = 0; i < length; j++) {
				if (board[i][j] != '.') {
					int num = Character.getNumericValue(board[i][j]);
					if (taken.get(num - 1)) return false;
					taken.set(num - 1, true);
				}
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int lowerBoundX = i * 3;
				int upperBoundX = (i + 1) * 3;
				int lowerBoundY = j * 3;
				int upperBoundY = (j + 1) * 3;
				ArrayList<Boolean> taken = new ArrayList<Boolean>(length);
				for (int p = 1; p <= length; p++) taken.add(false);
				
				for (int p = lowerBoundX; p < upperBoundX; p++) {
					for (int q = lowerBoundY; q < upperBoundY; q++) {
						if (board[p][q] != '.') {
							int num = Character.getNumericValue(board[p][q]);
							if (taken.get(num - 1)) return false;
							taken.set(num - 1, true);
						}
					}
				}
			}
		}
		
		return true;
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
