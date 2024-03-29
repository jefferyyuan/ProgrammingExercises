package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * Source: http://oj.leetcode.com/problems/word-search/
 */

public class WordSearch extends Exercise {
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
    
    @Override
    public void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    // Depth-first search
    private boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return (word.length() == 0);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existPartial(board, word, i, j)) return true;
            }
        }
        
        return false;
    }
    
    private boolean existPartial(char[][] board, String word, int i, int j) {
        if (word.length() == 0) return true;
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*') {
            return false;
        }
        
        if (board[i][j] == word.charAt(0)) {
            if (word.length() == 1) return true;
            
            char temp = board[i][j];
            board[i][j] = '*';
            
            String subString = word.substring(1);
            if (existPartial(board, subString, i - 1, j) 
                    || existPartial(board, subString, i + 1, j) 
                    || existPartial(board, subString, i, j - 1)
                    || existPartial(board, subString, i, j + 1)) {
                return true;
            }
            
            // Restore the board
            board[i][j] = temp;
        }
        
        return false;
    }

    @Override
    public boolean test() {
        for (int index = 0; index < testSuite.length; index++) {
            TestCase test = testSuite[index];
            
            int rows = test.board.length;
            int cols = test.board[0].length;
            
            for (int wordIndex = 0; wordIndex < test.words.length; wordIndex++) {
                char[][] board = new char[rows][cols];
                
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        board[i][j] = test.board[i][j];
                    }
                }

                System.out.println("For the following board:");
                for (char[] row : test.board) {
                    for (char c : row) {
                        System.out.printf("%c ", c);
                    }
                    System.out.println();
                }
                
                boolean canBeFound = exist(board, test.words[wordIndex]);
                System.out.printf(
                        "%s %s be found%n", test.words[wordIndex], (canBeFound)? "can" : "cannot");
                System.out.println("------------------");
            }
        }
        
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
