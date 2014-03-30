package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * Source: http://oj.leetcode.com/problems/subsets/
 */

public class Subsets implements LeetCodeExercise {
	private final int[][] testSuite = {
			{}, 
			{1}, 
			{1, 2, 3}, 
			{1, 2, 3, 4}, 
			{4, 1, 0}};
	
	private int index;
	private ArrayList<ArrayList<Integer>> result;

	@Override
	public void initialize() {
		result = new ArrayList<ArrayList<Integer>>();
	}

	@Override
	public void runExercise() {
		initialize();
		for (index = 0; index < testSuite.length; index++) {
			result = subsets(testSuite[index]);
			test();
		}
	}
	
	/*
	 * Classic BFS, build the next level based on the previous level.
	 * Note that it is restricted that elements should be in non-descending order. 
	 */
	private ArrayList<ArrayList<Integer>> subsets(int[] set) {
		int length = set.length;
		
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		subsets.add(new ArrayList<Integer>());
		
		if (length == 0) return subsets;
		Arrays.sort(set);

		int thisLevelMaxIndex = 0;
		int lastLevelMinIndex = 0;
		int lastLevelMaxIndex = 0;
		for (int i = 0; i < length; i++) {
			for (int j = lastLevelMinIndex; j <= lastLevelMaxIndex; j++) {
				ArrayList<Integer> subset = subsets.get(j);
				
//				Get the maximum value of the previous level
				int lastMax = Integer.MIN_VALUE;
				for (int p = 0; p < subset.size(); p++) {
					if (subset.get(p) > lastMax) {
						lastMax = subset.get(p);
					}
				}

				/*
				 * Build a new subset by adding one new element.
				 * New new element should be larger than the maximum of the previous level
				 */
				int index = 0;
				while (index < set.length && set[index] <= lastMax) {
					index++;
				}
				
				for (int p = index; p < length; p++) {
					ArrayList<Integer> s = new ArrayList<Integer>(subset);
					s.add(set[p]);
					subsets.add(s);
					thisLevelMaxIndex++;
				}
			}
			
			lastLevelMinIndex = lastLevelMaxIndex + 1;
			lastLevelMaxIndex = thisLevelMaxIndex;
		}
		
        return subsets;
    }

	@Override
	public boolean test() {
		System.out.printf("For the set [ ");
		for (int n : testSuite[index]) System.out.printf("%d ", n);
		System.out.printf("], the subsets are:%n\t");
		for (ArrayList<Integer> subset : result) {
			int size = subset.size();
			for (int i = 0; i < size; i++) System.out.printf("%d ", subset.get(i));
			
			System.out.println();
		}
		return false;
	}

}
