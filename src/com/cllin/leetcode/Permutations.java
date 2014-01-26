package com.cllin.leetcode;

import java.util.ArrayList;

public class Permutations implements LeetCodeExercise {
	private final int SIZE = 5;
	private final int MAXIMUM = 5;

	private int[] numbers;
	private ArrayList<ArrayList<Integer>> permutations;
	
	@Override
	public void initialize() {
		numbers = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			numbers[i] = (int)(Math.random() * MAXIMUM);
		}
	}

	@Override
	public void runExercise() {
		initialize();

		permutations = permute(numbers);
		
		test();
	}
	
    private ArrayList<ArrayList<Integer>> permute(int[] num) {
    	int length = num.length;
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	result.add(new ArrayList<Integer>());
    	
    	if (length == 0) return result;
    	
    	for (int i = 0; i < length; i++) {
    		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
    		int[] n = new int[length - 1];
    		
    		int index = 0;
    		for (int j = 0; j < length; j++) {
    			if (j != i) {
    				n[index] = num[j];
    				index++;
    			}
    		}
    		
    		r = permute(n);
    		for (ArrayList<Integer> l : r) l.add(num[i]); 
    		
    		result.addAll(r);
    	}
    	
    	for (int i = 0; i < result.size(); i++) {
    		if (result.get(i).size() < length) result.remove(i);
    		
    		for (int j = i + 1; j < result.size(); j++) {
    			boolean identical = true;
    			for (int k = 0; k < length; k++) {
    				if (result.get(i).get(k) != result.get(j).get(k)) {
    					identical = false;
    					break;
    				}
    			}
    			
    			if (identical) result.remove(j);
    		}
    	}
    	
        return result;
    }

	@Override
	public boolean test() {
		System.out.printf("There are %d permutation for:%n", permutations.size());
		
		for (int n : numbers) System.out.printf("%d ", n);
		System.out.println();
		
		return false;
	}

}
