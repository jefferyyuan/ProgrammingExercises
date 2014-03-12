package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

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
    	
    	ArrayList<ArrayList<Integer>> result = getPowerSet(numbers);
    	
    	for (int i = 0; i < result.size(); i++) {
    		for (int j = i + 1; j < result.size(); j++) {
    			if (result.get(i).size() == result.get(j).size()) {
    				ArrayList<Integer> subset = result.get(j);
    				int size = subset.size();
    				
    				boolean isIdentical = true;
    				for (int k = 0; k < size; k++) {
    					if (result.get(i).get(k).intValue() != result.get(j).get(k).intValue()) {
    						isIdentical = false;
    						break;
    					}
    				}
    				
//    				Check if duplicate subsets appear in sequence 
    				if (isIdentical) result.remove(j--);
    			}
    		}
    	}
    	
        return result;
    }
    
    private ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set) {
    	int size = set.size();
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (size == 0) {
    		result.add(new ArrayList<Integer>());
    		return result;
    	}
    	
    	int head = set.get(0);
    	ArrayList<Integer> rest = new ArrayList<Integer>();
    	for (int i = 1; i < size; i++) rest.add(set.get(i));
    	
    	ArrayList<ArrayList<Integer>> subsets = getPowerSet(rest);
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
