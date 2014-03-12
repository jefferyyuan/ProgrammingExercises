package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class BestTimetoBuyandSellStockII implements LeetCodeExercise {
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
		for (SIZE = 2; SIZE <= 100; SIZE++) {
			initialize();
			int maximumProfit = maxProfit(prices);
			System.out.printf("The maximum profit possible is %d%n", maximumProfit);
		}
	}
	
    private int maxProfit(int[] prices) {
    	if (prices.length <= 1) return 0;
    	
        int length = prices.length;
    	int profit = 0;
    	int boughtInPrice = 0;
        boolean haveStock = false;
        
        
        for(int i = 0; i < length; i++){
        	if (i == length - 1) {
        		if (haveStock) {
        			profit += (prices[i] - boughtInPrice);
        			haveStock = false;
        		}
    			break;
        	}
        	
        	if (haveStock) {
        		if (prices[i + 1] < prices[i]) {
        			profit += (prices[i] - boughtInPrice);
        			haveStock = false;
        		}
        	} else {
        		if (prices[i + 1] > prices[i]) {
        			boughtInPrice = prices[i];
        			haveStock = true;
        		}
        	}
        }
        
        return profit;
    }

	@Override
	public boolean test() {
		return false;
	}

}
