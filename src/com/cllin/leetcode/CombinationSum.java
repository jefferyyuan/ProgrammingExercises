package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡K , ak) must be in non-descending order. (ie, a1 <= a2 <= ¡K <= ak).
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is: 
 * 		[7]
 * 		[2, 2, 3]
 * 
 * Source: http://oj.leetcode.com/problems/combination-sum/
 */

public class CombinationSum implements LeetCodeExercise {
	private static final int[][] testSuite = new int[][]{
		{}, 
		{7, 3, 2},
		{2, 3, 6, 7},
		{5, 10, 8, 4, 3, 12, 9},
		{9, 6, 8, 11, 5, 4},
		{92, 71, 89, 74, 102, 91, 70, 119, 86, 116, 114, 106, 80, 81, 115, 99, 117, 93, 76, 77, 111, 110, 75, 104, 95, 112, 94, 73}
	};
	
	private int index;
	private int target;
	private ArrayList<ArrayList<Integer>> result;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 5; index < testSuite.length; index++) {
			for (target = 310; target <= 310; target++) {
				long start = System.nanoTime();
				
				result = combinationSum(testSuite[index], target);
				if (!test()) System.out.println("Failed");
				
				long end = System.nanoTime();
				System.out.println("\nTime Cost=" + (double) ((end - start) / 1000000) + "ms");
			}
		}
	}
	
//	Depth-first search
	private ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		if (candidates.length == 0 || target <= 0) return solution;

		Arrays.sort(candidates);
		
		return getCombination(new ArrayList<Integer>(), candidates, target);
	}
	
	private ArrayList<ArrayList<Integer>> getCombination(ArrayList<Integer> current, int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		
		if (target < 0) return solution;
		else if (target == 0) {
			solution.add(current);
			return solution;
		}
		
		int length = candidates.length;
		int start = (current.size() > 0)? Arrays.binarySearch(candidates, current.get(current.size() - 1)) : 0;
		
		for (int i = start; i < length && candidates[i] <= target; i++) {
			ArrayList<Integer> c = new ArrayList<Integer>(current);
			c.add(candidates[i]);
			
			solution.addAll(getCombination(c, candidates, target - candidates[i]));
		}
		
		return solution;
	}

	@Override
	public boolean test() {
		System.out.print("For this set of candidates: { ");
		for (int i = 0; i < testSuite[index].length; i++) System.out.printf("%d ", testSuite[index][i]);
		System.out.printf("} and %d as the target, there are %d combinations: %n", target, result.size());
		
		for (ArrayList<Integer> combination : result) {
			int sum = 0;
			for (int i = 0; i < combination.size(); i++) {
				System.out.printf("%d ", combination.get(i));
				sum += combination.get(i);
			}
			if (sum != target) return false;
			System.out.println();
		}
		
		System.out.println();
		return true;
	}

}
