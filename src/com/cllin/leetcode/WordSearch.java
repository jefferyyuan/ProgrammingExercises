package com.cllin.leetcode;

public class WordSearch implements LeetCodeExercise {
	private final TestCase[] testSuite = {
			new TestCase(
					new char[][]{
							{'A', 'B', 'C', 'E'},
							{'S', 'F', 'C', 'S'},
							{'A', 'D', 'E', 'E'}
					},
					new String[]{
							"ABCCED",
							"SEE",
							"ABCB"
					})
	};
	
	private int index;
	private int wordIndex;
	private boolean canBeFound;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			TestCase test = testSuite[index];
			
			int rows = test.board.length;
			int cols = test.board[0].length;
			
			for (wordIndex = 0; wordIndex < test.words.length; wordIndex++) {
				char[][] board = new char[rows][cols];
				
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						board[i][j] = test.board[i][j];
					}
				}
				
				canBeFound = exist(board, test.words[wordIndex]);
				test();
			}
		}
	}
	
	private boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0) return word.length() == 0;
		
		int rows = board.length;
		int cols = board[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (existPartial(board, word, i, j)) return true;
			}
		}
		
    	return false;
    }
	
	private boolean existPartial(char[][] board, String word, int i, int j) {
		if (word.length() == 0) return true;
		
		int rows = board.length;
		int cols = board[0].length;
		
		if (i < 0 || i >= rows || j < 0 || j >= cols) {
			return false;
		}
		
		if (board[i][j] == '*') {
			return false;
		}
		
		if (board[i][j] == word.charAt(0)) {
			if (word.length() == 1) return true;
			
			char temp = board[i][j];
			board[i][j] = '*';
			
			String subString = word.substring(1);
			if (existPartial(board, subString, i - 1, j)) {
				return true;
			}
			
			if (existPartial(board, subString, i + 1, j)) {
				return true;
			}
			
			if (existPartial(board, subString, i, j - 1)) {
				return true;
			}
			
			if (existPartial(board, subString, i, j + 1)) {
				return true;
			}
			
			board[i][j] = temp;
			return false;
		} else {
			return false;
		}
    }

	@Override
	public boolean test() {
		TestCase test = testSuite[index];
		
		System.out.println("For the following board:");
		for (char[] row : test.board) {
			for (char c : row) {
				System.out.printf("%c ", c);
			}
			System.out.println();
		}
		
		System.out.printf("%s %s be found%n", test.words[wordIndex], (canBeFound)? "can" : "cannot");
		System.out.println("------------------");
		return true;
	}
	
	private class TestCase {
		char[][] board;
		String[] words;
		
		TestCase(char[][] board, String[] words) {
			this.board = board;
			this.words = words;

		}
	}

}
