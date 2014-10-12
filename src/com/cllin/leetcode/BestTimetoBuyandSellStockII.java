package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * 
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * 
 * Source: http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

public class BestTimetoBuyandSellStockII extends LeetCodeExercise {
    private final int MAXIMUM = 100;
    
    private int SIZE = 100;
    private int[] prices;
    
    @Override
    public void initialize() {
        prices = new int[SIZE];
        
        for(int i = 0; i < SIZE; i++){
            prices[i] = (int)(Math.random() * MAXIMUM);
        }
    }

    @Override
    public void run() {
        for (SIZE = 2; SIZE <= 100; SIZE++) {
            initialize();
            int maximumProfit = maxProfit(prices);
            System.out.printf("The maximum profit possible is %d%n", maximumProfit);
        }
    }
    
    private int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int profit = 0;
        
        for (int i = 1; i <= prices.length - 1; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }

    @Override
    public boolean test() {
        return false;
    }

}
