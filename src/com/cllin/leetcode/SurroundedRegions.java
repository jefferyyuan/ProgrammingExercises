package com.cllin.leetcode;

import java.util.LinkedList;

import com.cllin.main.LeetCodeExercise;

public class SurroundedRegions implements LeetCodeExercise {

	private final char[][][] testSuite = {
			{
				{'O', 'X', 'X', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'},
				{'X', 'O', 'X', 'X'}
			},
			{
				{'O', 'O', 'O', 'O'},
				{'O', 'O', 'O', 'O'},
				{'O', 'O', 'O', 'O'},
				{'O', 'O', 'O', 'O'}
			}
	};
	
	private int index;
	private char[][] board;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			
	    	int rows = testSuite[index].length;
	    	int cols = testSuite[index][0].length;
	    	board = new char[rows][cols];
	    	for (int i = 0; i < rows; i++) {
	    		for (int j = 0; j < cols; j++) {
	    			board[i][j] = testSuite[index][i][j];
	    		}
	    	}
			
			solve(board);
			test();
		}
	}
	
	private void solve(char[][] board) {
    	if (board == null || board.length == 0) return;
    	
    	int rows = board.length;
    	int cols = board[0].length;
    	
    	LinkedList<Integer> visitedUnsurroundedX = new LinkedList<Integer>();
    	LinkedList<Integer> visitedUnsurroundedY = new LinkedList<Integer>();
    	
    	for (int i = 0; i < rows; i++) {
    		if (board[i][0] == 'O') {
    			visitedUnsurroundedX.add(i);
    			visitedUnsurroundedY.add(0);
    		}
    		
    		if (board[i][cols - 1] == 'O') {
    			visitedUnsurroundedX.add(i);
    			visitedUnsurroundedY.add(cols - 1);
    		}
    	}
    	
    	for (int j = 0; j < cols; j++) {
    		if (board[0][j] == 'O') {
    			visitedUnsurroundedX.add(0);
    			visitedUnsurroundedY.add(j);
    		}
    		
    		if (board[rows - 1][j] == 'O') {
    			visitedUnsurroundedX.add(rows - 1);
    			visitedUnsurroundedY.add(j);
    		}
    	}
    	
    	while (!visitedUnsurroundedX.isEmpty()) {
    		int x = visitedUnsurroundedX.poll();
    		int y = visitedUnsurroundedY.poll();

    		board[x][y] = 'U';
    		
    		if (x != 0 && board[x - 1][y] == 'O') {
    			visitedUnsurroundedX.add(x - 1);
    			visitedUnsurroundedY.add(y);
    		}
    		
    		if (x != rows - 1 && board[x + 1][y] == 'O') {
    			visitedUnsurroundedX.add(x + 1);
    			visitedUnsurroundedY.add(y);
    		}
    		
    		if (y != 0 && board[x][y - 1] == 'O') {
    			visitedUnsurroundedX.add(x);
    			visitedUnsurroundedY.add(y - 1);
    		}
    		
    		if (y != cols - 1 && board[x][y + 1] == 'O') {
    			visitedUnsurroundedX.add(x);
    			visitedUnsurroundedY.add(y + 1);
    		}
    	}
    	
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
    			if (board[i][j] == 'O') board[i][j] = 'X';
    		}
    	}
    	
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
    			if (board[i][j] == 'U') board[i][j] = 'O';
    		}
    	}
    }

	@Override
	public boolean test() {
		System.out.println("Before:");
		for (char[] row : testSuite[index]) {
			for (char c: row) {
				System.out.printf("%c ", c);
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("After:");
		for (char[] row : board) {
			for (char c: row) {
				System.out.printf("%c ", c);
			}
			System.out.println();
		}
		
		System.out.println("\n------------------");
		return true;
	}

}
