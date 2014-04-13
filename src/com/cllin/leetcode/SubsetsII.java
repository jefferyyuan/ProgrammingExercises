package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If S = [1,2,2], a solution is:
 * 	[
 * 	  [2],
 * 	  [1],
 * 	  [1,2,2],
 * 	  [2,2],
 * 	  [1,2],
 * 	  []
 * 	]
 * 
 * Source: http://oj.leetcode.com/problems/subsets-ii/
 */

public class SubsetsII implements LeetCodeExercise {
	private final int[][] testSuite = {
			{}, 
			{1}, 
			{1, 2, 3, 4}, 
			{4, 1, 0}, 
			{1, 2, 2}, 
			{1, 1, 2, 2}, 
			{5, 6, 5, 6, 7}};
	
	private int index;
	private ArrayList<ArrayList<Integer>> result;

	@Override
	public void initialize() {
		result = new ArrayList<ArrayList<Integer>>();
	}

	@Override
	public void runExercise() {
		initialize();
		for (index = 5; index < testSuite.length; index++) {
			result = subsetsWithDup(testSuite[index]);
			test();
		}
	}
	
    private ArrayList<ArrayList<Integer>> subsetsWithDup(int[] set) {
    	int length = set.length;
    	ArrayList<Integer> numbers = new ArrayList<Integer>();

    	Arrays.sort(set);
    	for (int i = 0; i < length; i++) numbers.add(set[i]);
    	
    	HashSet<ArrayList<Integer>> powerSet = getPowerSet(numbers, 0);
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	result.addAll(powerSet);
    	
        return result;
    }
    
    private HashSet<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set, int start) {
    	int size = set.size();
    	HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
    	
    	if (start == size) {
    		result.add(new ArrayList<Integer>());
    		return result;
    	}
    	
    	int head = set.get(start);
    	HashSet<ArrayList<Integer>> subsets = getPowerSet(set, start + 1);
    	
    	for (ArrayList<Integer> subset : subsets) {
    		ArrayList<Integer> newSubset = new ArrayList<Integer>();
    		newSubset.add(head);
    		newSubset.addAll(subset);
    		
    		result.add(subset);
    		result.add(newSubset);
    	}
    	
    	return result;
    }

	@Override
	public boolean test() {
		System.out.printf("For the set [ ");
		for (int n : testSuite[index]) System.out.printf("%d ", n);
		System.out.printf("], the subsets are:%n");
		for (ArrayList<Integer> subset : result) {
			int size = subset.size();
			
			System.out.print("- ");
			for (int i = 0; i < size; i++) System.out.printf("%d ", subset.get(i));
			System.out.print("-\n");
		}
		return false;
	}
}
