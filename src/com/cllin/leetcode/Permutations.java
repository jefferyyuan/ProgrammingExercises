package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * 		[1,2,3] have the following permutations:
 * 		[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * Source: http://oj.leetcode.com/problems/permutations/
 */

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
    	
    	int[] n = new int[length - 1];
    	for (int i = 0; i < length; i++) {
    		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
    		
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
    	
//    	This is not necessary if it is guaranteed that there are no duplicate elements 
    	for (int i = 0; i < result.size(); i++) {
    		if (result.get(i).size() < length) result.remove(i);
    		
    		for (int j = i + 1; j < result.size(); j++) {
    			if (result.get(i).equals(result.get(j))) result.remove(j);
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
