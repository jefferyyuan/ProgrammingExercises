package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * There are pots of gold arranged in a line, each containing some gold coins. 
 * Two players, A and B, can see how many coins are there in each gold pot.
 * 
 * They get alternating turns in which the player can pick a pot from one of the ends of the line. 
 * The winner is the player which has a higher number of coins at the end. 
 * 
 * The objective is to "maximize" the number of coins collected by A, assuming B also plays optimally. A starts the game. 
 * 
 * Find an optimal strategy that makes A win knowing that B is playing optimally as well. 
 * 
 * Source: http://www.careercup.com/question?id=15422849
 */

public class PotsOfGold extends Exercise {

    private final int PICKS = 5;
    private final int SIZE = PICKS * 2;
    private final int MAXIMUM = 10;
    
    private int[] pots;
    private int maximum;
    
    @Override
    public void run() {
        initialize();
        maximum = maximumGold(pots);
        test();
    }
    
    private int[][] strategy;
    private int[][] gold;
    private int maximumGold(int[] pots) {
        int length = pots.length;
        gold = new int[length][length];
        strategy = new int[length][length];
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                gold[i][j] = Integer.MIN_VALUE;
            }
        }
        
        return getGold(pots, 0, pots.length - 1);
    }
    
    /*
     * P(i, j) = The pot sequence starts at the i-th pot and ends at the j-th pot
     * M(i, j) = Maximum gold can get in P(i, j)
     * 
     * M(i, j) = Maximum(
     *                 P(i) + Minimum(M(i + 2, j), M(i + 1, j - 1)),    
     *                                     ------ A chooses i, B chooses the larger one of M(i + 2, j) and M(i + 1, j - 1)
     *                 P(j) + Minimum(M(i, j - 2), M(i + 1, j - 1))
     *                                     ------ B chooses j, B chooses the larger one of M(i, j + 2) and M(i + 1, j - 1)
     *                 )
     */
    private int getGold(int[] pots, int start, int end) {
        if (start > end) return 0;
        if (gold[start][end] != Integer.MIN_VALUE) return gold[start][end];
        
        int pathA = pots[start] + Math.min(getGold(pots, start + 2, end), getGold(pots, start + 1, end - 1));
        int pathB = pots[end] + Math.min(getGold(pots, start, end - 2), getGold(pots, start + 1, end - 1));
        
        gold[start][end] = Math.max(pathA, pathB);
        strategy[start][end] = (pathA > pathB)? start : end;
        
        return gold[start][end];
    }
    
    protected void initialize() {
        pots = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            pots[i] = (int) (Math.random() * MAXIMUM) + 1;
        }
    }

    protected void test() {
        System.out.print("Gold = { ");
        for (int n : pots) {
            System.out.printf("%d ", n);
        }
        System.out.printf("}%n");
        
        System.out.print("Strategy = { ");
        int move;
        int start = 0;
        int end = pots.length - 1;
        while (start < end) {
            move = strategy[start][end];
            System.out.printf("%d ", pots[move]);
            
            if (move == start) {
                start++;
            } else {
                end--;
            }
            
            if (pots[start] > pots[end]) {
                start++;
            } else {
                end--;
            }
        }
        System.out.printf("}%n");
        
        System.out.printf("Sum = %d%n", maximum);
    }
}
