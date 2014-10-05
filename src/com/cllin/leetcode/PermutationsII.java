package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * Source: http://oj.leetcode.com/problems/permutations-ii/
 */

public class PermutationsII implements LeetCodeExercise {
	private final int[][] testSuite = {
			{},
			{1},
			{1, 2, 3},
			{1, 1, 2},
			{-1, -1, 3, -1}
	};
	
	private int index;
	ArrayList<ArrayList<Integer>> result;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		for (index = 2; index < testSuite.length; index++) {
			result = permuteUnique(testSuite[index]);
			test();
		}
	}

	private ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	int length = num.length;
    	
    	if (length == 0) {
    		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    		result.add(new ArrayList<Integer>());
    		return result;
    	}
    	
    	Arrays.sort(num);
        return getPermutations(num, 1);
    }
	
    private ArrayList<ArrayList<Integer>> getPermutations(int[] num, int level) {
    	int length = num.length;
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	if (level == num.length) {
    		for (int i = 0; i < length; i++) {
    			if (num[i] != Integer.MIN_VALUE) {
    				ArrayList<Integer> r = new ArrayList<Integer>();
    				r.add(num[i]);
    				result.add(r);
    				return result;
    			}
    		}
    	}
    	
    	for (int i = 0; i < length; i++) {
    		if (num[i] == Integer.MIN_VALUE) continue;
    		if (i > 0 && num[i] == num[i - 1]) continue;
    		
    		int temp = num[i];
    		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();

    		num[i] = Integer.MIN_VALUE;
    		
    		r = getPermutations(num, level + 1);
    		for (ArrayList<Integer> l : r) l.add(temp); 
    		
    		result.addAll(r);
    		num[i] = temp;
    	}
    	
        return result;
    }
	
	@Override
	public boolean test() {
		System.out.print("For the set [ ");
		for (int n : testSuite[index]) System.out.printf("%d ", n);
		System.out.print("], the permutions are:\n");
		
		for (ArrayList<Integer> permution : result) {
			for (int n : permution) System.out.printf("%d ", n);
			System.out.println();
		}
		
		System.out.println("------------------");
		return true;
	}

}
