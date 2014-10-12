package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Determine if a Sudoku is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * 
 * Source: http://oj.leetcode.com/problems/valid-sudoku/
 */

public class ValidSudoku implements LeetCodeExercise {

    @Override
    public void initialize() {
        // TODO Auto-generated method stub

    }

    @Override
    public void run() {
        isValidSudoku(new char[0][0]);
    }
    
    private boolean isValidSudoku(char[][] board) {
        if (board.length == 0 || board.length != board[0].length) return false;
        
        int length = board.length;
        
//        Check by row
        for (int i = 0; i < length; i++) {
            ArrayList<Boolean> taken = new ArrayList<Boolean>(length);
            for (int p = 1; p <= length; p++) taken.add(false);
            
            for (int j = 0; j < length; j++) {
                if (board[i][j] == '.') continue;
                
                int num = Character.getNumericValue(board[i][j]);
                if (taken.get(num - 1)) return false;
                taken.set(num - 1, true);
            }
        }
        
//        Check by column
        for (int j = 0; j < length; j++) {
            ArrayList<Boolean> taken = new ArrayList<Boolean>(length);
            for (int p = 1; p <= length; p++) taken.add(false);
            
            for (int i = 0; i < length; j++) {
                if (board[i][j] == '.') continue;
                
                int num = Character.getNumericValue(board[i][j]);
                if (taken.get(num - 1)) return false;
                taken.set(num - 1, true);
            }
        }
        
//        Check by grid
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
                        if (board[i][j] == '.') continue;
                        
                        int num = Character.getNumericValue(board[p][q]);
                        if (taken.get(num - 1)) return false;
                        taken.set(num - 1, true);
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
