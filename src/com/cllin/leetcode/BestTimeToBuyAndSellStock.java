package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * Source: http://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class BestTimeToBuyAndSellStock implements LeetCodeExercise {
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
        for (SIZE = 0; SIZE <= 100; SIZE++) {
            initialize();
            int maximumProfit = maxProfit(prices);
            System.out.printf("The maximum profit possible is %d%n", maximumProfit);
        }
    }
    
    private int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        
        int profit = 0;
        int maximumProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(0, profit + prices[i] - prices[i - 1]);
            maximumProfit = Math.max(maximumProfit, profit);
        }
        
        return maximumProfit;
    }

    @Override
    public boolean test() {
        // TODO Auto-generated method stub
        return false;
    }

}
