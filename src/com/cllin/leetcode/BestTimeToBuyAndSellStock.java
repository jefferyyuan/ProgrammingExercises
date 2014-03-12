package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;


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
	public void runExercise() {
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
    	int length = prices.length;
    	int[] profits = new int[length - 1];
    	
    	for (int i = 0; i < length - 1; i++) {
    		profits[i] = prices[i + 1] - prices[i];
    	}
    	
    	for (int i = 0; i < length - 1; i++) {
    		profit += profits[i];
    		
    		if (profit > maximumProfit) maximumProfit = profit;
    		if (profit < 0) profit = 0;
    	}
    	
    	return maximumProfit;
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
