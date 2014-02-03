package com.cllin.leetcode;

import java.util.ArrayList;

public class Combinations implements LeetCodeExercise {
	private final int MAXIMUM = 10;
	
	private int n;
	private int k;
	
	private ArrayList<ArrayList<Integer>> result;
	

	@Override
	public void initialize() {
		n = (int)(Math.random() * MAXIMUM) + 1;
		k = (int)(Math.random() * n);
	}

	@Override
	public void runExercise() {
		
		for (int i = 1; i <= 10; i++) {
			initialize();
			result = combine(n, k);
			
			if (test()) System.out.printf("There are %d combinations for %d integers from 1 to %d%n", result.size(), k, n);
			else System.out.println("Failed");	
		}
	}
	
    private ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	if (n == 0 || n < k) return result;
    	
    	if (k == 0) {
    		return result;
    	} else if (k == 1) {
        	for (int i = 1; i <= n; i++) {
        		ArrayList<Integer> c = new ArrayList<Integer>();
        		c.add(new Integer(i));
        		result.add(c);
        	}
        	
        	return result;
    	}
    	
    	ArrayList<ArrayList<Integer>> combinations = combine(n, k - 1);
    	
    	for (ArrayList<Integer> combination : combinations) {
    		int max = 0;
    		for (int num : combination) {
    			if (num > max) max = num;
    		}
    		
    		for (int i = max; i <= n; i++) {
    			if (!combination.contains(new Integer(i))) {
    				ArrayList<Integer> c = new ArrayList<Integer>(combination);
    				c.add(new Integer(i));
    				
    				result.add(c);
    			}
    		}
    	}
    	
    	return result;
    }

	@Override
	public boolean test() {
		int size = result.size();
    	
		if (k == 0) return (size == 0)? true : false;
		
    	double result = 1;
    	for (int i = 1; i <= k; i++) {
    		result /= i;
    		result *= (n - k + i);
    	}
    	
    	return ((int) result == size)? true : false;
	}

}
