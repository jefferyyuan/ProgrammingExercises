package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * 
 * Source: http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */

public class BestTimeToBuyAndSellStockIII extends LeetCodeExercise {
    private final int[][] testSuite = {
            {1, 2},
            {2, 1},
            {1, 2, 4, 2, 5, 7, 2, 4, 9, 0}
    };
    
    private int index;
    private int maximumProfit;
    
    @Override
    public void initialize() {
//        TODO
    }

    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            initialize();
            maximumProfit = maxProfit(testSuite[index]);
            
            test();
        }
    }
    
    private int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        
        int length = prices.length;
        int[] historyMaximumProfit = new int[length];
        int[] futureMaximumProfit = new int[length];
        Arrays.fill(historyMaximumProfit, 0);
        Arrays.fill(futureMaximumProfit, 0);
        
        int valley = prices[0];
        int peak = prices[length - 1];
        int maximumProfit = 0;
        
        for (int i = 1; i < length; i++) {
            valley = Math.min(valley, prices[i]);
            historyMaximumProfit[i] = Math.max(prices[i] - valley, historyMaximumProfit[i - 1]);
        }
        
        for (int i = length - 2; i >= 0; i--) {
            peak = Math.max(peak, prices[i]);
            futureMaximumProfit[i] = Math.max(peak - prices[i], futureMaximumProfit[i + 1]);
            
            maximumProfit = Math.max(historyMaximumProfit[i] + futureMaximumProfit[i], maximumProfit);
        }
        
        return maximumProfit;
    }

    @Override
    public boolean test() {
        System.out.printf("The maximum profit from the below prices is %d%n", maximumProfit);
        
        System.out.print("{ ");
        for (int price : testSuite[index]) System.out.printf("%d ", price);
        System.out.print("}\n");
        
        System.out.println("------------------");
        
        return true;
    }

}
