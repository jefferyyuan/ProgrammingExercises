package com.cllin.algorithms;

import com.cllin.main.Exercise;

public class RodCutting extends Exercise{
    
    private final int[][] testSuite = {
            {1, 5, 8, 9, 10, 17, 17, 20},
            {3, 5, 8, 9, 10, 17, 17, 20},
            {1, 5, 8, 9, 10, 17, 17, 20, 24, 30}
    };
    
    @Override
    public void run() {
        for (int[] test : testSuite) {
            
            System.out.print("For P = { ");
            
            int[] prices = test;
            for (int price : prices) {
                System.out.printf("%d ", price);
            }
            
            System.out.printf("}%nR = %d%n", rodCutting(prices));
        }
    }
    
    /*
     * P(i) = Price of a rod with length i
     * R(i) = Maximum revenue from a rod with length i
     *   
     * R(i) = Maximum(    P(i),
     *                     M(i - 1) + M(1),
     *                     M(i - 2) + M(2),
     *                     M(i - 3) + M(3),
     *                     ...
     *                     M(1) + M(i - 1))
     */
    private int rodCutting(int[] prices){
        if (prices.length < 1) return 0;
        
        int[] revenues = new int[prices.length + 1];
        revenues[0] = 0;
        
        for(int i = 1; i <= prices.length; i++){
            int max = prices[i - 1];
            
            for (int j = 0; j <= i / 2; j++) {
                max = Math.max(max, revenues[i - j] + revenues[j]);
            }
            
            revenues[i] = max;
        }
        
        return revenues[prices.length];
    }
}
