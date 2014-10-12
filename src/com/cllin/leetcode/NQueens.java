package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * Source: http://oj.leetcode.com/problems/n-queens/
 */

public class NQueens extends LeetCodeExercise {

    private int N;
    private ArrayList<String[]> result;
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        for (N = 0; N <= 5; N++) {
            result = solveNQueens(N);
            test();
        }
    }
    
    private static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> boards = new ArrayList<String[]>();
        if (n < 1) return boards;

        boolean[][] chessBoard = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) chessBoard[i][j] = true; 
        }
        
        ArrayList<ArrayList<Integer>> maps = placeQueen(0, n, chessBoard);
        
//        Translate the maps to the requested form
        for (ArrayList<Integer> map : maps) {
            String[] board = new String[n];
            
            for (int i = 0; i < n; i++) {
                int queenIdx = map.get(i);
                StringBuffer row = new StringBuffer(n);
                
                for (int j = 0; j < n; j++) {
                    if (j == queenIdx) row.append('Q');
                    else row.append('.');
                }
                
                board[i] = row.toString();
            }
            boards.add(board);
        }
        
        return boards;
    }
    
    private static ArrayList<ArrayList<Integer>> placeQueen(int col, int n, boolean[][] chessBoard) {
        ArrayList<ArrayList<Integer>> boards = new ArrayList<ArrayList<Integer>>();
        if (col == n) return boards;

//        For 0 <= i < n, try placing the queen at (i, col)
        for (int i = 0; i < n; i++) {
//            Advance if (i, col is safe),
            if (isSafe(i, col, n, chessBoard)) {
                
                chessBoard[i][col] = false;
                ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
                
//                Advance to next column and store all possible solution
                b.addAll(placeQueen(col + 1, n, chessBoard));
                
                if (boards.size() > 0) {
//                    If solution is found, clear all places after this column for further explorations
                    for (int p = 0; p < n; p++) {
                        for (int q = col; q < n; q++) chessBoard[p][q] = true;
                    }
                } else {
//                    Else, just clear this place for further explorations
                    chessBoard[i][col] = true;
                }
                
//                Add to the solution set if a new solution is found
                if (col == n - 1) {
                    ArrayList<Integer> solution = new ArrayList<Integer>();
                    solution.add(i);
                    boards.add(solution);
                    return boards;
                } else {
                    for (ArrayList<Integer> board : b) {
                        board.add(i);
                    }
                    boards.addAll(b);
                }
            }
        }
        
        return boards;
    }
    
    private static boolean isSafe(int x, int y, int n, boolean[][] chessBoard) {
//        Check vertically and horizontally
        for (int i = x; i >= 0; i--) if (!chessBoard[i][y]) return false; 
        for (int j = y; j >= 0; j--) if (!chessBoard[x][j]) return false; 

//        Check diagonally
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--)     if (!chessBoard[i][j]) return false; 
        for (int i = x, j = y; i < n && j >= 0; i++, j--) if (!chessBoard[i][j]) return false; 
        
        return true;
    }

    @Override
    public boolean test() {
        int size = result.size();
        System.out.printf("There are %d distinct solutions for a %d-queens problem%n", size, N);
        
        for (String[] solution : result) {
            for (String row : solution) System.out.println(row);
            System.out.println("------------------");
        }
        
        return false;
    }

}
